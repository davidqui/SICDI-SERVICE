package com.laamware.ejercito.doc.web.docwebservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento extends AuditActivoModifySupport {

	@Id
	@GenericGenerator(name = "TIPO_DOCUMENTO_SEQ", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "TIPO_DOCUMENTO_SEQ"),
			@Parameter(name = "allocationSize", value = "1") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_DOCUMENTO_SEQ")
	@Column(name = "TDC_ID")
	private Integer id;

	@Column(name = "TDC_NOMBRE")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "PLA_ID")
	private Plantilla plantilla;

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

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
