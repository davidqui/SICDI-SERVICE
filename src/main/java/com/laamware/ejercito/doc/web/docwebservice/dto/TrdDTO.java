/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO para la información saliente de las trds en SICDI.
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 16/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
public class TrdDTO implements Serializable{
    
    
    private Integer id;
    private String nombre;
    private String codigo;
    private List<TrdDTO> subTrds;

    public TrdDTO(Integer id, String nombre, String codigo, List<TrdDTO> subTrds) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.subTrds = subTrds;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<TrdDTO> getSubTrds() {
        return subTrds;
    }

    public void setSubTrds(List<TrdDTO> subTrds) {
        this.subTrds = subTrds;
    }
    
    
      
}
