/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.repo;

import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import com.laamware.ejercito.doc.web.docwebservice.entity.Trd;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sdelgadom
 */
public interface TrdRepository extends JpaRepository<Trd, Integer>{
    
    List<Trd> findBySerieAndActivoTrue(Integer serie, Sort sort);

    List<Trd> findByActivoAndSerieNull(Boolean activo, Sort sort);

}
