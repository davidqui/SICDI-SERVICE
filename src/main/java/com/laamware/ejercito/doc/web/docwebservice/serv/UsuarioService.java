/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.dto.UsuarioDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para {@link Usuario} del web service de SICDI
 * @author David Quijano Ramos
 * @since 1
 * @version 20/11/2018 Issue #1 (SICDI-GETDE) feature-1
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    
    
    public Usuario findByLogin(String login) {


        return usuarioRepository.findOneByLoginAndActivoTrue(login);
    }




}
