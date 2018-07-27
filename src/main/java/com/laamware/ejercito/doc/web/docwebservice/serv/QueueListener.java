package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laamware.ejercito.doc.web.docwebservice.dto.DocumentoDTO;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * servicio para la recepción de contenido del activeMQ
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 23/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
@Component
public class QueueListener {
    
    final static Integer PROCESO_ID = 9;
    
    @Autowired
    private DocumentoService documentoService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /***
     * Metodo que recibe los elementos del activeMQ para crear los documentos.
     * @param documento 
     */
    @Transactional
    @JmsListener(destination = "WEB_SERVICE_ACTIVEMQ_QUEUE")
    public void receptorDocumentos(String documento){
        try {
            ObjectMapper mapper = new ObjectMapper();
            DocumentoDTO doc = mapper.readValue(documento, DocumentoDTO.class);
            documentoService.crearDocumento(PROCESO_ID, usuarioRepository.getOne(9999), doc);
        } catch (Exception ex) {
            
        }
    }
}
