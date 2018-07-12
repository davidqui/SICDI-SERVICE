package com.laamware.ejercito.doc.web.docwebservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRADO")
public class Grados extends AuditActivoModifySupport {

    @Id
    @Column(name = "GRA_ID")
    private String id;

    @Column(name = "GRA_NOMBRE")
    private String nombre;

    /*
         * 2017-10-05 edison.gonzalez@controltechcg.com Issue #131: Variable que 
	 * permite almacenar el peso.
     */
    @Column(name = "GRA_PESO_ORDEN", precision = 0)
    private Integer pesoOrden;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPesoOrden() {
        return pesoOrden;
    }

    public void setPesoOrden(Integer pesoOrden) {
        this.pesoOrden = pesoOrden;
    }
}
