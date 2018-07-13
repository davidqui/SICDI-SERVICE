/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.entity.Documento;
import com.laamware.ejercito.doc.web.docwebservice.repo.DocumentoRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.InstanciaRepository;
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

    public void crearDocumento(Integer proId, Usuario usuId){
        
        try {
            // Se crea la instancia del proceso
            String pin = procesoService.instancia(proId, usuId);
            Instancia procesoInstancia = procesoService.instancia(pin);
            final Documento documento = Documento.create();
            documento.setInstancia(procesoInstancia);
            documento.setEstadoTemporal(Documento.ESTADO_TEMPORAL);
            documento.setElabora(usuId);
            documento.setUsuarioUltimaAccion(usuId);

            procesoInstancia.setVariable(Documento.DOC_ID, documento.getId());
            instanciaRepository.save(procesoInstancia);

            documentoRepository.saveAndFlush(documento);
            System.out.println("OK DOCUMENTO "+documento.toString()+" intancia "+pin);
            
        } catch (DatabaseException ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
