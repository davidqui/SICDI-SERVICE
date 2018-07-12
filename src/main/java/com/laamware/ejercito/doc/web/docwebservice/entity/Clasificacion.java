package com.laamware.ejercito.doc.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CLASIFICACION")
public class Clasificacion {

    @Id
    @GenericGenerator(name = "CLASIFICACION_SEQ", strategy = "sequence", parameters = {
        @Parameter(name = "sequence", value = "CLASIFICACION_SEQ")
        ,@Parameter(name = "allocationSize", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASIFICACION_SEQ")
    @Column(name = "CLA_ID")
    private Integer id;

    @Column(name = "CLA_NOMBRE")
    private String nombre;

    @Column(name = "CLA_ORDEN")
    private Integer orden;
    
    @Column(name = "ACTIVO")
    private Integer activo;

    /**
     * Constructor vacío.
     */
    /*
     * 2018-05-17 jgarcia@controltechcg.com Issue #162 (SICDI-Controltech)
     * feature-162.
     */
    public Clasificacion() {
    }

    /**
     * Constructor.
     *
     * @param id ID.
     */
    /*
     * 2018-05-17 jgarcia@controltechcg.com Issue #162 (SICDI-Controltech)
     * feature-162.
     */
    public Clasificacion(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    
    

}
