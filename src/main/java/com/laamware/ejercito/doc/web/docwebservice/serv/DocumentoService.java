/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
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
    public ProcesoService procesoService;

    public void crearDocumento(Integer proId, Usuario usuId){
        
        try {
            // Se crea la instancia del proceso
            String pin = procesoService.instancia(proId, usuId);
        } catch (DatabaseException ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
