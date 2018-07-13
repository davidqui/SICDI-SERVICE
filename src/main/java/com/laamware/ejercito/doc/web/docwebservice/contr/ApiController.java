/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.contr;

import com.laamware.ejercito.doc.web.docwebservice.contr.dto.DocumentoDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Clasificacion;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioRepository;
import com.laamware.ejercito.doc.web.docwebservice.serv.ClasificacionService;
import com.laamware.ejercito.doc.web.docwebservice.serv.DocumentoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sdelgadom
 */
@Controller
@RequestMapping(value = ApiController.PATH)
public class ApiController {
    public static final String PATH = "/test-documento";
    
//    @Autowired
//    private ClasificacionService clasificacionService;
    
    @Autowired
    private DocumentoService documentoService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ResponseEntity<List<Clasificacion>> clasificaciones(){
//        System.out.println("com.laamware.ejercito.doc.web.docwebservice.contr.TestController.clasificaciones()");
//        List<Clasificacion> users = clasificacionService.findAllActivoOrderByOrden();
//        if (users.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            // You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Clasificacion>>(users, HttpStatus.OK);
//    }
    
    @RequestMapping(path="", method= RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postDocumento(@RequestBody DocumentoDTO document){
        documentoService.crearDocumento(9, usuarioRepository.getOne(141));
        
        System.out.println(document.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
