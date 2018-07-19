/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author sdelgadom
 */
@Entity
@Table(name = "USUARIO_WS")
public class UsuarioWs {
    
    @Id
    @SequenceGenerator(name = "USUARIO_WS_SEQ", sequenceName = "USUARIO_WS_SEQ", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_WS_SEQ")
    @Column(name = "USU_ID")
    private Integer id;
    
    @Column(name = "USU_CODIGO")
    private String codigo;

    @Column(name = "USU_CLAVE")
    private String apiKey;

    public UsuarioWs(String codigo, String apiKey) {
        this.codigo = codigo;
        this.apiKey = apiKey;
    }

    public UsuarioWs() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    
    
}
