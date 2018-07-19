/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.contr.dto.DocumentoDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.entity.Documento;
import com.laamware.ejercito.doc.web.docwebservice.repo.DocumentoRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.InstanciaRepository;
import java.util.Date;
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

    public void crearDocumento(Integer proId, Usuario usuId, DocumentoDTO docInfo){
        
        try {
            // Se crea la instancia del proceso
            final Documento documento = Documento.create();
            final Dependencia dependencia = dependenciaService.findByID(docInfo.getDependencia());
            String pin = procesoService.instancia(proId, usuId);
            Instancia procesoInstancia = procesoService.instancia(pin);
            System.out.println("PASA  "+dependencia+" != "+ pin);
            System.out.println("PASA1!");
            documento.setInstancia(procesoInstancia);
            documento.setEstadoTemporal(Documento.ESTADO_TEMPORAL);
            documento.setElabora(usuId);
            documento.setUsuarioUltimaAccion(usuId);
            documento.setQuien(usuId.getId());
            documento.setCuando(new Date());
            System.out.println("PASA11.1!= "+procesoInstancia.getEstado());
            procesoInstancia.setVariable(Documento.DOC_ID, documento.getId(), dependencia.getId());
            procesoInstancia.setVariable(Documento.DOC_STICKER_DATOS_COMPLETOS, "true", dependencia.getId());
            procesoInstancia.setVariable(Documento.DOC_PUEDE_ARCHIVAR, "true", dependencia.getId());
            procesoInstancia.setVariable(Documento.DOC_PUEDE_DAR_RESPUESTA, "true", dependencia.getId());
            procesoInstancia.setVariable(Documento.DOC_VISTO_BUENO, "false", dependencia.getId());
            System.out.println("PASA11.2!= "+procesoInstancia.getEstado());
            procesoInstancia.setAsignado(dependencia.getUsuarioRegistro());
            System.out.println("PASA2!= "+procesoInstancia.getEstado());
            instanciaRepository.saveAndFlush(procesoInstancia);
            
            System.out.println("PASA3!");
            
            documento.setGradoExterno(docInfo.getGrado());
            documento.setRemitenteNombre(docInfo.getNombreRemitente());
            documento.setRemitenteTitulo(docInfo.getTituloRemitente());
            documento.setAsunto(docInfo.getAsunto());
            documento.setNumeroOficio(docInfo.getNumeroOficio());
            documento.setFechaOficio(docInfo.getFechaOficio());
            documento.setNumeroFolios(docInfo.getNumeroFolios());
            //TODO DEFINIR -- -- 
            documento.setClasificacion(null);
            documento.setDescripcion(docInfo.getTrazabilidad());
            documento.setCuando(new Date());           
            
            
            documentoRepository.saveAndFlush(documento);
            System.out.println("OK DOCUMENTO "+documento.toString()+" intancia "+pin);
            
        } catch (DatabaseException ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
