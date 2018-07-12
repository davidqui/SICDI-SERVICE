/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Usuario;
import com.laamware.ejercito.doc.web.docwebservice.repo.InstanciaRepository;
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
    public InstanciaRepository instanciaRepository;
    
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
        instanciaRepository.saveAndFlush(i);
        String id = i.getId();
        return id;
    }
}
