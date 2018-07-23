package com.laamware.ejercito.doc.web.docwebservice.repo;

import com.laamware.ejercito.doc.web.docwebservice.entity.Estado;
import com.laamware.ejercito.doc.web.docwebservice.entity.Instancia;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProcesoEstadoRepository extends JpaRepository<Estado, String> {

    @Query(nativeQuery = true, value = ""
            + "select * from PROCESO_ESTADO WHERE PRO_ID = :pro_id and pes_inicial = 1")
    public Estado findEstadoInicialByProId(@Param("pro_id") Integer pro_id);
}
