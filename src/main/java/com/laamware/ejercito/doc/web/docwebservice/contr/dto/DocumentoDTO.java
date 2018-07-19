/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.contr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO para la información entrante de un documento del web service.
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 12/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */

public class DocumentoDTO implements Serializable{
    
    @JsonProperty("grado")
    private String grado;
    @JsonProperty("nombre_remitente")
    private String nombreRemitente;
    @JsonProperty("titulo_remitente")
    private String tituloRemitente;
    @JsonProperty("asunto")
    private String asunto;
    @JsonProperty("numero_oficio")
    private String numeroOficio;
    
    @JsonProperty("fecha_oficio")
    private Date fechaOficio;
    @JsonProperty("numero_folios")
    private Integer numeroFolios;
    @JsonProperty("trazabilidad")
    private String trazabilidad;
    @JsonProperty("clasificacion")
    private String clasificacion;
    
    @JsonProperty("archivo")
    private String archivo;
    
    @JsonProperty("dependencia")
    private Integer dependencia;
    
    @JsonProperty("descripcion")
    private String descripcion;

//    public DocumentoDTO(@JsonProperty("grado") String grado, @JsonProperty("nombre_remitente") String nombreRemitente, @JsonProperty("titulo_remitente") String tituloRemitente,
//            @JsonProperty("asunto") String asunto, @JsonProperty("numero_oficio") String numeroOficio, @JsonProperty("fecha_oficio") Date fechaOficio, 
//            @JsonProperty("numero_folios") Integer numeroFolios, @JsonProperty("trazabilidad") String trazabilidad, @JsonProperty("clasificacion") String clasificacion, 
//            @JsonProperty("archivo") String archivo) {
//        this.grado = grado;
//        this.nombreRemitente = nombreRemitente;
//        this.tituloRemitente = tituloRemitente;
//        this.asunto = asunto;
//        this.numeroOficio = numeroOficio;
//        this.fechaOficio = fechaOficio;
//        this.numeroFolios = numeroFolios;
//        this.trazabilidad = trazabilidad;
//        this.clasificacion = clasificacion;
//        this.archivo = archivo;
//    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getTituloRemitente() {
        return tituloRemitente;
    }

    public void setTituloRemitente(String tituloRemitente) {
        this.tituloRemitente = tituloRemitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public Date getFechaOficio() {
        return fechaOficio;
    }

    public void setFechaOficio(Date fechaOficio) {
        this.fechaOficio = fechaOficio;
    }

    public Integer getNumeroFolios() {
        return numeroFolios;
    }

    public void setNumeroFolios(Integer numeroFolios) {
        this.numeroFolios = numeroFolios;
    }

    public String getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(String trazabilidad) {
        this.trazabilidad = trazabilidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getDependencia() {
        return dependencia;
    }

    public void setDependencia(Integer dependencia) {
        this.dependencia = dependencia;
    } 

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "DocumentoDTO{" + "grado=" + grado + ", nombreRemitente=" + nombreRemitente + ", tituloRemitente=" + tituloRemitente + ", asunto=" + asunto + ", numeroOficio=" + numeroOficio + ", fechaOficio=" + fechaOficio + ", numeroFolios=" + numeroFolios + ", trazabilidad=" + trazabilidad + ", clasificacion=" + clasificacion + ", archivo=" + archivo + '}';
    }
}
