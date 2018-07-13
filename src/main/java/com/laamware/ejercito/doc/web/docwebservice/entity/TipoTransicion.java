package com.laamware.ejercito.doc.web.docwebservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCESO_TRANSICION_TIPO")
public class TipoTransicion extends AuditActivoModifySupport {

	@Id
	@Column(name = "PTT_ID")
	private Integer id;

	@Column(name = "PTT_NOMBRE")
	private String nombre;

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

	@Override
	public String toString() {
		return this.nombre;
	}
}
