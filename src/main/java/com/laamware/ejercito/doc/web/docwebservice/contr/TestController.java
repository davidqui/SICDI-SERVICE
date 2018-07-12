/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.contr;

import com.laamware.ejercito.doc.web.docwebservice.serv.ClasificacionService;
import com.laamware.ejercito.doc.web.entity.Clasificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sdelgadom
 */
@Controller
@RequestMapping(value = TestController.PATH)
public class TestController {
    public static final String PATH = "/test-documento";
    
    @Autowired
    private ClasificacionService clasificacionService;
    
    @RequestMapping(value = "/clas/", method = RequestMethod.GET)
    public ResponseEntity<List<Clasificacion>> clasificaciones(){
        List<Clasificacion> users = clasificacionService.findAllActivoOrderByOrden();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Clasificacion>>(users, HttpStatus.OK);
    }
}
