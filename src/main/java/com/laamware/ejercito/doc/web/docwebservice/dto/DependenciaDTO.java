/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO para la información saliente de las dependencias en SICDI.
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 16/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
public class DependenciaDTO implements Serializable{
    
    private String nombre;
    private Integer id;
    private String ciudad;
    private String direccion;
    private List<DependenciaDTO> subDependencias;

    public DependenciaDTO(String nombre, Integer id, String ciudad, String direccion, List<DependenciaDTO> subDependencias) {
        this.nombre = nombre;
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.subDependencias = subDependencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<DependenciaDTO> getSubDependencias() {
        return subDependencias;
    }

    public void setSubDependencias(List<DependenciaDTO> subDependencias) {
        this.subDependencias = subDependencias;
    }
    
    
}
