/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.UsuarioWs;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioWsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author sdelgadom
 */
@Service
public class UsuarioWsService {
    
    @Autowired
    private UsuarioWsRepository usuarioWsRepository;
    
    
    
    
    public Boolean VerificarAuth(String condigo, String apiKey){
        UsuarioWs user = usuarioWsRepository.findOneByCodigoAndApiKey(condigo, apiKey);
        return user != null;
    }
}
