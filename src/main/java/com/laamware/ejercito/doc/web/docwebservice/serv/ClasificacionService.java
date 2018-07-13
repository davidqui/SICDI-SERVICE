/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.Clasificacion;
import com.laamware.ejercito.doc.web.docwebservice.repo.ClasificacionRepository;

import java.util.List;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author sdelgadom
 */
@Service
public class ClasificacionService {
    
        @Autowired
        private ClasificacionRepository clasificacionRepository;
            
        public synchronized List<Clasificacion> findAllActivoOrderByOrden() {
            List<Clasificacion> listaClas = clasificacionRepository.findAll();
            return listaClas;
        }
}
