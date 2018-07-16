/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.entity.Variable;
import com.laamware.ejercito.doc.web.docwebservice.repo.InstanciaRepository;
import com.laamware.ejercito.doc.web.docwebservice.repo.VariableRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author egonzalezm
 * @since 1.8
 * @version 07/12/2018
 */
@Service
public class ProcesoService {

    @Autowired
    private InstanciaRepository instanciaRepository;
    
    @Autowired
    private VariableRepository variableRepository;
    
    /**
     * Crea una nueva instancia de un proceso. Tener en cuenta que la instancia
     * que devuelve no contiene las dependencias cargadas.
     *
     * @param procesoId Identificador del proceso
     * @param usuario El usuario que crea la instancia
     * @return El identificador de la nueva instancia
     * @throws com.laamware.ejercito.doc.web.docwebservice.serv.DatabaseException
     */
    public String instancia(Integer procesoId, Usuario usuario) throws DatabaseException {

        // Crea la instancia. La base de datos se encarga de asignar el estado
        // inicial y las variables de proceso con sus respectivos valores
        // iniciales
        Instancia i = Instancia.create(procesoId);
        i.setAsignado(usuario);
        i.setCuando(new Date());
        i.setQuien(usuario.getId());
        i.setCuandoMod(new Date());
        i.setQuienMod(usuario.getId());
        instanciaRepository.saveAndFlush(i);
        String id = i.getId();
        return id;
    }
    
    /**
     * Obtiene el objeto de instancia de proceso
     *
     * @param pin Identificador único de la instancia
     * @return El objeto de instancia de proceso
     */
    public Instancia instancia(String pin) {
        Instancia i = instanciaRepository.getOne(pin);
        i.setService(this);
        return i;
    }
    
    public Variable setVariable(Instancia instancia, String key, String value, Integer usuID) {
        Variable v = instancia.findVariable(key);
        if (v != null) {
            v.setValue(value);
            v.setCuando(new Date());
            v.setQuien(usuID);
            v.setActivo(Boolean.TRUE);
            variableRepository.save(v);
        } else {
            v = new Variable(key, value, instancia);
            instancia.getVariables().add(v);
            v.setCuando(new Date());
            v.setQuien(usuID);
            v.setActivo(Boolean.TRUE);
            variableRepository.save(v);
        }
        return v;
    }
}
