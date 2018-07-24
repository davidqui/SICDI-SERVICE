/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.contr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laamware.ejercito.doc.web.docwebservice.dto.DependenciaDTO;
import com.laamware.ejercito.doc.web.docwebservice.dto.DocumentoDTO;
import com.laamware.ejercito.doc.web.docwebservice.dto.TrdDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Clasificacion;
import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import com.laamware.ejercito.doc.web.docwebservice.repo.UsuarioRepository;
import com.laamware.ejercito.doc.web.docwebservice.serv.ClasificacionService;
import com.laamware.ejercito.doc.web.docwebservice.serv.DependenciaService;
import com.laamware.ejercito.doc.web.docwebservice.serv.DocumentoService;
import com.laamware.ejercito.doc.web.docwebservice.serv.QueueService;
import com.laamware.ejercito.doc.web.docwebservice.serv.TrdService;
import com.laamware.ejercito.doc.web.docwebservice.serv.UsuarioWsService;
import java.util.Enumeration;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sdelgadom
 */
@Controller
@RequestMapping(value = ApiController.PATH)
public class ApiController {
    public static final String PATH = "/test-documento";
    
    @Autowired
    private ClasificacionService clasificacionService;
    
    @Autowired
    private DocumentoService documentoService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioWsService usuarioWsService;
    
    @Autowired
    private DependenciaService dependenciaService;
    
    @Autowired
    private TrdService trdService;
    
    @Autowired
    private QueueService queueService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Clasificacion>> clasificaciones(){
        System.out.println("com.laamware.ejercito.doc.web.docwebservice.contr.TestController.clasificaciones()");
        List<Clasificacion> users = clasificacionService.findAllActivoOrderByOrden();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Clasificacion>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/dependencias", method = RequestMethod.GET)
    public ResponseEntity<List<DependenciaDTO>> dependencias(){
        System.out.println("com.laamware.ejercito.doc.web.docwebservice.contr.TestController.clasificaciones()");
        List<DependenciaDTO> dependencias = dependenciaService.dependencias();
        if (dependencias.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DependenciaDTO>>(dependencias, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/trds", method = RequestMethod.GET)
    public ResponseEntity<List<TrdDTO>> trds(){
        System.out.println("com.laamware.ejercito.doc.web.docwebservice.contr.TestController.clasificaciones()");
        List<TrdDTO> trds = trdService.trds();
        if (trds.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TrdDTO>>(trds, HttpStatus.OK);
    }
    
    
    @RequestMapping(path="", method= RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postDocumento(@RequestBody DocumentoDTO document, HttpServletRequest request){
        if (!authVerification(request)) 
            return new ResponseEntity<>("No se proveyeron credenciales o son incorrectas",HttpStatus.UNAUTHORIZED);
        String errors = DocumentoDTO.validarInfo(document);
        if (!errors.isEmpty())
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        final Optional<Dependencia> dependencia = dependenciaService.findByID(document.getDependencia());
        if (!dependencia.isPresent())
            return new ResponseEntity<>("{errores:[{\"dependencia\":\"No existe una dependencia con el id " + document.getDependencia() + "\"}]}",HttpStatus.BAD_REQUEST);
        if (dependencia.get().getUsuarioRegistro() == null)
            return new ResponseEntity<>("{errores:[{\"dependencia\":\"No existe un usuario registro para la dependencia con el id " + document.getDependencia() + "\"}]}",HttpStatus.BAD_REQUEST);
        ObjectMapper mapper = new ObjectMapper();
        try {
            queueService.enviarACola(mapper.writeValueAsString(document));
        } catch (JsonProcessingException ex) {
            return new ResponseEntity<>("ERROR SERIALIZANDO EL OBJETO",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Creado Correctamente", HttpStatus.OK);
    }
    
    
    private Boolean authVerification(final HttpServletRequest request){
        
        Enumeration headerNames = request.getHeaderNames();
        String authUser = null;
        String authApiKey = null;
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            if (key.equals("username"))
                authUser = value;
            if (key.equals("x-api-key"))   
                authApiKey = value;
        }
        
        if (authUser == null || authApiKey == null)
            return Boolean.FALSE;
        
        System.out.println("AUTH OK R "+authApiKey+" "+authUser);
        
        return usuarioWsService.VerificarAuth(authUser, authApiKey);
    }
}
