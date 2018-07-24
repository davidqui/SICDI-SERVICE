/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO para la información entrante de un documento del web service.
 *
 * @author Samuel Delgado Muñoz
 * @since 1.8
 * @version 12/07/2018 Issue #173 (SICDI-Controltech) feature-173
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = DocumentoDTO.class)
public class DocumentoDTO implements Serializable {

    @JsonProperty("grado")
    private String grado;
    @JsonProperty("nombre_remitente")
    private String nombreRemitente;
    @JsonProperty("titulo_remitente")
    private String tituloRemitente;
    @JsonProperty("direccion_remitente")
    private String direccionRemitente;
    @JsonProperty("asunto")
    private String asunto;
    @JsonProperty("numero_oficio")
    private Integer numeroOficio;

    @JsonProperty("fecha_oficio")
    private Date fechaOficio;
    @JsonProperty("numero_folios")
    private Integer numeroFolios;
    @JsonProperty("trazabilidad")
    private String trazabilidad;
    @JsonProperty("clasificacion")
    private String clasificacion;
    @JsonProperty("bolsa_seguridad")
    private String bolsaSeguridad;

    @JsonProperty("archivo")
    private String archivo;

    @JsonProperty("dependencia")
    private Integer dependencia;

    @JsonProperty("descripcion")
    private String descripcion;

    public DocumentoDTO() {
    }

    public DocumentoDTO(String grado, String nombreRemitente, String tituloRemitente, String direccionRemitente, String asunto, Integer numeroOficio, Date fechaOficio, Integer numeroFolios, String trazabilidad, String clasificacion, String bolsaSeguridad, String archivo, Integer dependencia, String descripcion) {
        this.grado = grado;
        this.nombreRemitente = nombreRemitente;
        this.tituloRemitente = tituloRemitente;
        this.direccionRemitente = direccionRemitente;
        this.asunto = asunto;
        this.numeroOficio = numeroOficio;
        this.fechaOficio = fechaOficio;
        this.numeroFolios = numeroFolios;
        this.trazabilidad = trazabilidad;
        this.clasificacion = clasificacion;
        this.bolsaSeguridad = bolsaSeguridad;
        this.archivo = archivo;
        this.dependencia = dependencia;
        this.descripcion = descripcion;
    }


    
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

    public Integer getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(Integer numeroOficio) {
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

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public void setDireccionRemitente(String direccionRemitente) {
        this.direccionRemitente = direccionRemitente;
    }

    public String getBolsaSeguridad() {
        return bolsaSeguridad;
    }

    public void setBolsaSeguridad(String bolsaSeguridad) {
        this.bolsaSeguridad = bolsaSeguridad;
    }

    @Override
    public String toString() {
        return "DocumentoDTO{" + "grado=" + grado + ", nombreRemitente=" + nombreRemitente + ", tituloRemitente=" + tituloRemitente + ", asunto=" + asunto + ", numeroOficio=" + numeroOficio + ", fechaOficio=" + fechaOficio + ", numeroFolios=" + numeroFolios + ", trazabilidad=" + trazabilidad + ", clasificacion=" + clasificacion + ", archivo=" + archivo + '}';
    }

    public static String validarInfo(DocumentoDTO documento) {
        boolean hasErrors = false;
        String message = "{errores:[";
        if (documento.getNombreRemitente() == null || documento.getNombreRemitente().trim().isEmpty()) {
            message += "{\"nombre_remitente\":\"Es un campo requerido\"},";
            hasErrors = true;
        }
        if (documento.getTituloRemitente() == null || documento.getTituloRemitente().trim().isEmpty()) {
            message += "{\"titulo_remitente\":\"Es un campo requerido\"},";
            hasErrors = true;
        }
        if (documento.getDireccionRemitente() == null || documento.getDireccionRemitente().trim().isEmpty()) {
            message += "{\"direccion_remitente\":\"Es un campo requerido\"},";
            hasErrors = true;
        }
        if (documento.getAsunto() == null || documento.getAsunto().trim().isEmpty()) {
            message += "{\"asunto\":\"Es un campo requerido\"},";
            hasErrors = true;

        }
        if (documento.getNumeroOficio() == null) {
            message += "{\"numero_oficio\":\"Es un campo requerido\"},";
            hasErrors = true;

        }
        if (documento.getFechaOficio() == null) {
            message += "{\"fecha_oficio\":\"Es un campo requerido\"},";
            hasErrors = true;

        }
        if (documento.getNumeroFolios() == null) {
            message += "{\"numero_folios\":\"Es un campo requerido\"},";
            hasErrors = true;
        }
        if (documento.getDependencia() == null) {
            message += "{\"dependencia\":\"Es un campo requerido\"},";
            hasErrors = true;
        }
        message = message.substring(0, message.length()-1)+"]}";
        if (!hasErrors)
            message = "";
        return message;
    }
}
