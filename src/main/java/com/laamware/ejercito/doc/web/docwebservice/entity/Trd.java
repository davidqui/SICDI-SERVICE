package com.laamware.ejercito.doc.web.docwebservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TRD")
public class Trd extends AuditActivoModifySupport{

    @Id
    @GenericGenerator(name = "TRD_SEQ", strategy = "sequence", parameters = {
        @Parameter(name = "sequence", value = "TRD_SEQ")
        ,
			@Parameter(name = "allocationSize", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRD_SEQ")
    @Column(name = "TRD_ID")
    private Integer id;

    @Column(name = "TRD_NOMBRE")
    private String nombre;

    @Column(name = "TRD_CODIGO")
    private String codigo;

    @Column(name = "TRD_SERIE")
    private Integer serie;

    @Column(name = "TRD_RET_ARCHIVO_GENERAL")
    private Integer retArchivoGeneral;

    @Column(name = "TRD_RET_ARCHIVO_CENTRAL")
    private Integer retArchivoCentral;

    @Column(name = "TRD_DIS_CT")
    private Boolean disposicionDT;

    @Column(name = "TRD_DIS_D")
    private Boolean disposicionD;

    @Column(name = "TRD_DIS_M")
    private Boolean disposicionM;

    @Column(name = "TRD_DIS_S")
    private Boolean disposicionS;

    @Column(name = "TRD_DIS_E")
    private Boolean disposicionE;

    @Column(name = "TRD_PROCEDIMIENTO")
    private String procedimiento;

    @ManyToOne
    @JoinColumn(name = "PLA_ID")
    private Plantilla plantilla;

    @ManyToOne
    @JoinColumn(name = "TDC_ID")
    private TipoDocumento tipoDocumento;

    @Column(name = "TRD_PLAZO")
    private Integer plazo;

    @Transient
    private List<Documento> documentos = new ArrayList<Documento>();

    /**
     * Lista de trds asociadas
     */
    @Transient
    private List<Trd> subs;

    /**
     * Constructor vacío.
     */
    /*
     * 2018-05-16 jgarcia@controltechcg.com Issue #162 (SICDI-Controltech)
     * feature-162.
     */
    public Trd() {
    }

    /**
     * Constructor.
     *
     * @param id ID.
     */
    /*
     * 2018-05-16 jgarcia@controltechcg.com Issue #162 (SICDI-Controltech)
     * feature-162.
     */
    public Trd(Integer id) {
        this.id = id;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getRetArchivoGeneral() {
        return retArchivoGeneral;
    }

    public void setRetArchivoGeneral(Integer retArchivoGeneral) {
        this.retArchivoGeneral = retArchivoGeneral;
    }

    public Integer getRetArchivoCentral() {
        return retArchivoCentral;
    }

    public void setRetArchivoCentral(Integer retArchivoCentral) {
        this.retArchivoCentral = retArchivoCentral;
    }

    public Boolean getDisposicionDT() {
        return disposicionDT;
    }

    public void setDisposicionDT(Boolean disposicionDT) {
        this.disposicionDT = disposicionDT;
    }

    public Boolean getDisposicionD() {
        return disposicionD;
    }

    public void setDisposicionD(Boolean disposicionD) {
        this.disposicionD = disposicionD;
    }

    public Boolean getDisposicionM() {
        return disposicionM;
    }

    public void setDisposicionM(Boolean disposicionM) {
        this.disposicionM = disposicionM;
    }

    public Boolean getDisposicionS() {
        return disposicionS;
    }

    public void setDisposicionS(Boolean disposicionS) {
        this.disposicionS = disposicionS;
    }

    public Boolean getDisposicionE() {
        return disposicionE;
    }

    public void setDisposicionE(Boolean disposicionE) {
        this.disposicionE = disposicionE;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Trd> getSubs() {
        return subs;
    }

    public void setSubs(List<Trd> subs) {
        this.subs = subs;
    }
}
