/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.dto.DocumentoDTO;
import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author sdelgadom
 */
@Service
public class QueueService {
    
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
        
    @Autowired
    private Queue queue;
    
    
    public void enviarACola(final String documento){
        jmsMessagingTemplate.convertAndSend(this.queue, documento);
    }
    
    
}
