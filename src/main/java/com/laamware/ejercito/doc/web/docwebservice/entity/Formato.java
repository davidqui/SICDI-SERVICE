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

/**
 * @author mcr
 *
 */
@Entity
@Table(name = "FORMATO")
public class Formato extends AuditActivoModifySupport {

	@Id
	@GenericGenerator(name = "FORMATO_SEQ", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "FORMATO_SEQ"),
			@Parameter(name = "allocationSize", value = "1") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORMATO_SEQ")
	@Column(name = "FORM_ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "DOC_ID")
	private Documento documento;

	@ManyToOne
	@JoinColumn(name = "TRD_ID")
	private Trd trd;

	@Column(name = "FORM_CONTENT")
	private String contenido;

	@Column(name = "FORM_ORIGINAL")
	private String original;

	@Column(name = "FORM_DESCRIPCION")
	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Trd getTrd() {
		return trd;
	}

	public void setTrd(Trd trd) {
		this.trd = trd;
	}

}
