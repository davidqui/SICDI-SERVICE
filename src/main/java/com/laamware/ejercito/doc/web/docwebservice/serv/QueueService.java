package com.laamware.ejercito.doc.web.docwebservice.serv;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * servicio para el envio de datos a la cola de activeMQ
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 23/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
@Service
public class QueueService {
    
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
        
    @Autowired
    private Queue queue;
    
    /***
     * Envia un JSON a la cola de ACTIVE MQ
     * @param documento 
     */
    public void enviarACola(final String documento){
        jmsMessagingTemplate.convertAndSend(this.queue, documento);
    }
    
}
