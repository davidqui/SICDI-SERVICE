package com.laamware.ejercito.doc.web.docwebservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author mcr
 *
 */
@Entity
@Table(name = "PERFIL")
public class Perfil extends AuditActivoModifySupport {

	@Id
	@GenericGenerator(name = "PERFIL_SEQ", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "PERFIL_SEQ"),
			@Parameter(name = "allocationSize", value = "1") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFIL_SEQ")
	@Column(name = "PER_ID")
	private Integer id;

	@Column(name = "PER_NOMBRE")
	private String nombre;

	@Column(name = "PER_DESCRIPCION")
	private String descripcion;

	@OneToMany
	@JoinColumn(name = "PER_ID")
	private List<PerfilRol> roles;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public List<PerfilRol> getRoles() {
		return roles;
	}

	public void setRoles(List<PerfilRol> roles) {
		this.roles = roles;
	}

}
