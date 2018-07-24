/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.serv;

import com.laamware.ejercito.doc.web.docwebservice.dto.DependenciaDTO;
import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import com.laamware.ejercito.doc.web.docwebservice.repo.DependenciaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Servicio para las dependeicas del web service de SICDI
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 16/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
@Service
public class DependenciaService {
    
    @Autowired
    private DependenciaRepository dependenciaRepository;
    
    
    public synchronized List<DependenciaDTO> dependencias(){
        return depsHierarchy();
    }
    
    
    public Optional<Dependencia> findByID(Integer id) {
        return dependenciaRepository.findById(id);
    }
    
    public List<DependenciaDTO> depsHierarchy() {
        /*
         * 2018-07-11 samuel.delgado@controltechcg.com Issue #179 (SICDI-Controltech)
         * feature-179: se agrega cache a ta respuesta.
         */
        List<Dependencia> root = dependenciaRepository.findByActivoAndPadreIsNullAndDepIndEnvioDocumentosTrue(true,
                new Sort(Sort.Direction.ASC, "pesoOrden", "nombre"));
        List<DependenciaDTO> listDep = new ArrayList<>();
        for (Dependencia d : root) {
            DependenciaDTO dep = new DependenciaDTO(d.getNombre(), d.getId(), d.getCiudad(),
                    d.getDireccion(), new ArrayList<DependenciaDTO>());
            depsHierarchy(dep);
            listDep.add(dep);
        }
        return listDep;
    }

    /*
	 * 2017-04-11 jvargas@controltechcg.com Issue #45: DEPENDENCIAS:
	 * Ordenamiento por peso. Modificación: variable y orden en que se presentan
	 * las dependencias.
     */
    public void depsHierarchy(DependenciaDTO d) {
        List<Dependencia> subs = dependenciaRepository.findByActivoAndDepIndEnvioDocumentosTrueAndPadre(true, d.getId(),
                new Sort(Sort.Direction.ASC, "pesoOrden", "nombre"));
        for (Dependencia x : subs) {
            DependenciaDTO dep = new DependenciaDTO(x.getNombre(), x.getId(), x.getCiudad(),
                    x.getDireccion(), new ArrayList<DependenciaDTO>());
            depsHierarchy(dep);
            d.getSubDependencias().add(dep);
        }
    }
}
