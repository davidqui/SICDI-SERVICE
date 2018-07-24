/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.dto.DocumentoDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.entity.Documento;
import com.laamware.ejercito.doc.web.docwebservice.entity.DocumentoObservacion;
import com.laamware.ejercito.doc.web.docwebservice.entity.Estado;
import com.laamware.ejercito.doc.web.docwebservice.repo.DocumentoObservacionRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.DocumentoRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.InstanciaRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.ProcesoEstadoRepository;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author egonzalezm
 * @since 1.8
 * @version 07/12/2018
 */
@Service
public class DocumentoService {

    @Autowired
    private ProcesoService procesoService;

    @Autowired
    private InstanciaRepository instanciaRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private DependenciaService dependenciaService;

    @Autowired
    private ProcesoEstadoRepository procesoEstadoRepository;

    @Autowired
    private DocumentoObservacionRepository documentoObservacionRepository;

    public void crearDocumento(Integer proId, Usuario usuId, DocumentoDTO docInfo){
        try {
            // Se crea la instancia del proceso
            final Documento documento = Documento.create();
            final Optional<Dependencia> dependencia = dependenciaService.findByID(docInfo.getDependencia());
            String pin = procesoService.instancia(proId, usuId);
            Instancia procesoInstancia = procesoService.instancia(pin);
            System.out.println("PASA  " + dependencia + " != " + pin);
            documento.setInstancia(procesoInstancia);
            documento.setEstadoTemporal(Documento.ESTADO_TEMPORAL);
            documento.setElabora(usuId);
            documento.setUsuarioUltimaAccion(usuId);
            documento.setQuien(usuId.getId());
            documento.setCuando(new Date());
            Estado estado = procesoEstadoRepository.findEstadoInicialByProId(procesoInstancia.getProceso().getId());
            procesoInstancia.setEstado(estado);
            final Dependencia pDependencia = dependencia.get();
            procesoService.setVariable(procesoInstancia, Documento.DOC_ID, documento.getId(), usuId.getId());
            procesoService.setVariable(procesoInstancia, Documento.DOC_STICKER_DATOS_COMPLETOS, "true", usuId.getId());
            procesoService.setVariable(procesoInstancia, Documento.DOC_PUEDE_ARCHIVAR, "true", usuId.getId());
            procesoService.setVariable(procesoInstancia, Documento.DOC_PUEDE_DAR_RESPUESTA, "true", usuId.getId());
            procesoService.setVariable(procesoInstancia, Documento.DOC_VISTO_BUENO, "false", usuId.getId());
            procesoInstancia.setAsignado(pDependencia.getUsuarioRegistro());
            instanciaRepository.saveAndFlush(procesoInstancia);

            documento.setGradoExterno(docInfo.getGrado());
            documento.setRemitenteNombre(docInfo.getNombreRemitente());
            documento.setRemitenteTitulo(docInfo.getTituloRemitente());
            documento.setAsunto(docInfo.getAsunto());
            documento.setNumeroOficio(docInfo.getNumeroOficio().toString());
            documento.setFechaOficio(docInfo.getFechaOficio());
            documento.setNumeroFolios(docInfo.getNumeroFolios());
            documento.setRemitenteDireccion(docInfo.getDireccionRemitente());
            documento.setNumeroBolsa(docInfo.getBolsaSeguridad());
            //TODO DEFINIR -- -- 
            documento.setClasificacion(null);
            documento.setDescripcion(docInfo.getTrazabilidad());
            documento.setCuando(new Date());

            documentoRepository.saveAndFlush(documento);

            if (docInfo.getDescripcion() != null) {
                DocumentoObservacion obs = new DocumentoObservacion();
                obs.setDocumento(documento);
                obs.setQuien(usuId.getId());
                obs.setCuando(new Date());
                String escaped = docInfo.getDescripcion().replace("&", "&amp;");
                escaped = escaped.replace("<", "&lt;");
                escaped = escaped.replace(">", "&gt;");
                escaped = escaped.replace("\n", "<br/>");
                obs.setTexto(escaped);
                documentoObservacionRepository.save(obs);
            }
            System.out.println("OK DOCUMENTO " + documento.toString() + " intancia " + pin);

        } catch (Exception ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
