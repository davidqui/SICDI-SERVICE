/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.repo;

import com.laamware.ejercito.doc.web.docwebservice.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sdelgadom
 */
public interface DocumentoRepository extends JpaRepository<Documento, String>{
    
}
