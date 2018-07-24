/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice;

import javax.jms.Queue;
import org.apache.activemq.ActiveMQXAConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 *
 * @author sdelgadom
 */
@Configuration
@EnableJms
public class ActiveMQConfig {
    private enum QueueName {
        WEB_SERVICE_ACTIVEMQ_QUEUE("com.laamware.ejercito.doc.web.dto.notifications");

        private final String dtoPackage;

        private QueueName(String dtoPackage) {
            this.dtoPackage = dtoPackage;
        }

        String getDtoPackage() {
            return dtoPackage;
        }
    }

    @Value("${spring.activemq.broker-url}")
    private String activeMQBrokerURL;

    /**
     * Bean de la cola para correo electrónico.
     *
     * @return Bean de ActiveMQ.
     */
    @Bean
    public Queue mailActiveMQQueue() {
        return new ActiveMQQueue(QueueName.WEB_SERVICE_ACTIVEMQ_QUEUE.name());
    }

    /**
     * Bean de la fábrica de conexiones al ActiveMQ.
     *
     * @return Bean de fábrica de conexiones.
     */
    @Bean
    public ActiveMQXAConnectionFactory mailActiveMQXAConnectionFactory() {
        final ActiveMQXAConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory(activeMQBrokerURL);
        // TODO: Revisar el trusted packages.
        return connectionFactory;
    }
}
