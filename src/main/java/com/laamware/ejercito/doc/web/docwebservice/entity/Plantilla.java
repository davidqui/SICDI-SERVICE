package com.laamware.ejercito.doc.web.docwebservice.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author mcr
 *
 */
@Entity
@Table(name = "PLANTILLA")
public class Plantilla extends AuditActivoModifySupport {

	@Id
	@GenericGenerator(name = "PLANTILLA_SEQ", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "PLANTILLA_SEQ"), @Parameter(name = "allocationSize", value = "1") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANTILLA_SEQ")
	@Column(name = "PLA_ID")
	private Integer id;

	@NotEmpty
	@Size(max = 32)
	@Column(name = "PLA_CODIGO")
	private String codigo;

	@Column(name = "PLA_CONTENIDO_CABEZA")
	private String contenidoCabeza;

	@Column(name = "PLA_CONTENIDO_PIE")
	private String contenidoPie;

	@Size(max = 10)
	@Column(name = "PLA_TIPO")
	private String tipo;

	@NotEmpty
	@Size(max = 255)
	@Column(name = "PLA_NOMBRE")
	private String nombre;

	@Column(name = "PLA_ARCHIVO")
	private String archivo;

	@Column(name = "TEXTO_DEFAULT")
	private String textoDefultPlantilla;

	@Column(name = "PLA_DOCX_DOCUMENTO")
	private String docx4jDocumento;
        
        @Column(name = "BOOK_NAME")
        private String bookmarkName;

        @Column(name = "BOOK_VALUE")
        private String bookmarkValue;

	@Transient
	private String idPlantillaSeleccionada = null;
        
        
        /*
            2018-06-27 samuel.delgado@controltechcg.com feature #176 : se agrega método para validar
            los wildcards que posee la plantilla.
        */
        @ManyToMany(cascade = { CascadeType.PERSIST })
        @JoinTable(
            name = "WILDCARD_PV_PLANTILLAS", 
            joinColumns = { @JoinColumn(name = "PLA_ID", referencedColumnName = "PLA_ID") }, 
            inverseJoinColumns = { @JoinColumn(name = "WPV_ID", referencedColumnName = "WPV_ID") }
        )
        private List<WildcardPlantilla> wildCardsPlantilla;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return codigo;
	}

	public String getContenidoCabeza() {
		return contenidoCabeza;
	}

	public void setContenidoCabeza(String contenidoCabeza) {
		this.contenidoCabeza = contenidoCabeza;
	}

	public String getContenidoPie() {
		return contenidoPie;
	}

	public void setContenidoPie(String contenidoPie) {
		this.contenidoPie = contenidoPie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getTextoDefultPlantilla() {
		return textoDefultPlantilla;
	}

	public void setTextoDefultPlantilla(String textoDefultPlantilla) {
		this.textoDefultPlantilla = textoDefultPlantilla;
	}

	public String getIdPlantillaSeleccionada() {
		return idPlantillaSeleccionada;
	}

	public void setIdPlantillaSeleccionada(String idPlantillaSeleccionada) {
		this.idPlantillaSeleccionada = idPlantillaSeleccionada;
	}

	public String getDocx4jDocumento() {
		return docx4jDocumento;
	}

	public void setDocx4jDocumento(String docx4jDocumento) {
		this.docx4jDocumento = docx4jDocumento;
	}
        
        public String getBookmark_name() {
            return bookmarkName;
        }

        public void setBookmarkName(String bookmarkName) {
            this.bookmarkName = bookmarkName;
        }

        public String getBookmarkValue() {
            return bookmarkValue;
        }

        public void setBookmarkValue(String bookmarkValue) {
            this.bookmarkValue = bookmarkValue;
        }

        public List<WildcardPlantilla> getWildCards() {
            return wildCardsPlantilla;
        }

        public void setWildCards(List<WildcardPlantilla> wildCardsPlantilla) {
            this.wildCardsPlantilla = wildCardsPlantilla;
        }
        
	public boolean plantillaTienePlantilla() {
		return docx4jDocumento != null && docx4jDocumento.trim().length() > 0;
	}

}
