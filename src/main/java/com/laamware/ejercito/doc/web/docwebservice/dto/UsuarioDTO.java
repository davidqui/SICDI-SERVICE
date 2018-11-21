/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laamware.ejercito.doc.web.docwebservice.dto;

import com.laamware.ejercito.doc.web.docwebservice.entity.Clasificacion;
import com.laamware.ejercito.doc.web.docwebservice.entity.Dependencia;

import java.io.Serializable;
import java.util.List;
import java.lang.String;
import java.lang.String;

/**
 * DTO para la información saliente de los Usuarios en SICDI.
 *
 * @author David Quijano
 * @since 1
 * @version 20/11/2018 Issue #1 (SICDI-GETDE) feature-1
 */
public class UsuarioDTO implements Serializable{


    private String nombre;
    private String login;
    private String clasificacion;
    private String dependencia;
    private String cargoPrincipal;
    private String cargo1;
    private String cargo2;
    private String cargo3;
    private String cargo4;
    private String cargo5;
    private String cargo6;
    private String cargo7;
    private String cargo8;
    private String cargo9;
    private String cargo10;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCargoPrincipal() {
        return cargoPrincipal;
    }

    public void setCargoPrincipal(String cargoPrincipal) {
        this.cargoPrincipal = cargoPrincipal;
    }

    public String getCargo1() {
        return cargo1;
    }

    public void setCargo1(String cargo1) {
        this.cargo1 = cargo1;
    }

    public String getCargo2() {
        return cargo2;
    }

    public void setCargo2(String cargo2) {
        this.cargo2 = cargo2;
    }

    public String getCargo3() {
        return cargo3;
    }

    public void setCargo3(String cargo3) {
        this.cargo3 = cargo3;
    }

    public String getCargo4() {
        return cargo4;
    }

    public void setCargo4(String cargo4) {
        this.cargo4 = cargo4;
    }

    public String getCargo5() {
        return cargo5;
    }

    public void setCargo5(String cargo5) {
        this.cargo5 = cargo5;
    }

    public String getCargo6() {
        return cargo6;
    }

    public void setCargo6(String cargo6) {
        this.cargo6 = cargo6;
    }

    public String getCargo7() {
        return cargo7;
    }

    public void setCargo7(String cargo7) {
        this.cargo7 = cargo7;
    }

    public String getCargo8() {
        return cargo8;
    }

    public void setCargo8(String cargo8) {
        this.cargo8 = cargo8;
    }

    public String getCargo9() {
        return cargo9;
    }

    public void setCargo9(String cargo9) {
        this.cargo9 = cargo9;
    }

    public String getCargo10() {
        return cargo10;
    }

    public void setCargo10(String cargo10) {
        this.cargo10 = cargo10;
    }

    public UsuarioDTO(String nombre, String login, String clasificacion, String dependencia, String cargoPrincipal, String cargo1, String cargo2, String cargo3, String cargo4, String cargo5, String cargo6, String cargo7, String cargo8, String cargo9, String cargo10) {
        this.nombre = nombre;
        this.login = login;
        this.clasificacion = clasificacion;
        this.dependencia = dependencia;
        this.cargoPrincipal = cargoPrincipal;
        this.cargo1 = cargo1;
        this.cargo2 = cargo2;
        this.cargo3 = cargo3;
        this.cargo4 = cargo4;
        this.cargo5 = cargo5;
        this.cargo6 = cargo6;
        this.cargo7 = cargo7;
        this.cargo8 = cargo8;
        this.cargo9 = cargo9;
        this.cargo10 = cargo10;
    }

    public UsuarioDTO() {
    }

   

   
}
