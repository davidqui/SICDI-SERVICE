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
 *
 * @author sdelgadom
 */
@Component
public class QueueListener {
    
    final static Integer PROCESO_ID = 9;
    
    @Autowired
    private DocumentoService documentoService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @JmsListener(destination = "WEB_SERVICE_ACTIVEMQ_QUEUE")
    @Transactional
    public void receptorDocumentos(String documento){
        try {
            ObjectMapper mapper = new ObjectMapper();
            DocumentoDTO doc = mapper.readValue(documento, DocumentoDTO.class);
            System.out.println("TRAIGO -- "+doc.toString());
            documentoService.crearDocumento(PROCESO_ID, usuarioRepository.getOne(9999), doc);
            System.out.println("Todo ok");
        } catch (Exception ex) {
            System.out.println("Ocurrio un error");
        }
    }
}
