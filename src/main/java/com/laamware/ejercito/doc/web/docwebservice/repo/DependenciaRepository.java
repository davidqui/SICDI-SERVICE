/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.repo;

import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sdelgadom
 */
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

    List<Dependencia> findByActivo(boolean activo, Sort sort);

    List<Dependencia> findByActivoAndDepIndEnvioDocumentosTrueAndPadre(boolean activo, Integer padreId, Sort sort);

    List<Dependencia> findByActivoAndPadreIsNullAndDepIndEnvioDocumentosTrue(boolean activo, Sort sort);
}
