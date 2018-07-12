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

/**
 * @author rafar
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario extends AuditActivoModifySupport {

    @Id
    @GenericGenerator(name = "USUARIO_SEQ", strategy = "sequence", parameters = {
        @Parameter(name = "sequence", value = "USUARIO_SEQ")
        , @Parameter(name = "allocationSize", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @Column(name = "USU_ID")
    private Integer id;

    @Column(name = "USU_LOGIN")
    private String login;

    @Column(name = "USU_PASSWORD")
    private String password = "nopassword";

    @Column(name = "USU_DOCUMENTO")
    private String documento;

    @Column(name = "USU_NOMBRE")
    private String nombre;

    @Column(name = "USU_TELEFONO")
    private String telefono;

    @JoinColumn(name = "USU_GRADO", referencedColumnName = "GRA_ID")
    @ManyToOne
    private Grados usuGrado;

    @ManyToOne
    @JoinColumn(name = "PER_ID")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "DEP_ID")
    private Dependencia dependencia;

    @ManyToOne
    @JoinColumn(name = "CLA_ID")
    private Clasificacion clasificacion;

    @Column(name = "USU_IMAGEN_FIRMA")
    private String imagenFirma;

    @Column(name = "USU_IMAGEN_FIRMA_EXT")
    private String imagenFirmaExtension;

    @Column(name = "UMA_ID")
    private Integer uma;

    @Column(name = "USU_EMAIL")
    private String email;

    @JoinColumn(name = "USU_CARGO_PRINCIPAL_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargoPrincipalId;

    @JoinColumn(name = "USU_CARGO1_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo1Id;

    @JoinColumn(name = "USU_CARGO2_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo2Id;

    @JoinColumn(name = "USU_CARGO3_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo3Id;

    @JoinColumn(name = "USU_CARGO4_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo4Id;

    @JoinColumn(name = "USU_CARGO5_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo5Id;

    @JoinColumn(name = "USU_CARGO6_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo6Id;

    @JoinColumn(name = "USU_CARGO7_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo7Id;

    @JoinColumn(name = "USU_CARGO8_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo8Id;

    @JoinColumn(name = "USU_CARGO9_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo9Id;

    @JoinColumn(name = "USU_CARGO10_ID", referencedColumnName = "CAR_ID")
    @ManyToOne
    private Cargo usuCargo10Id;

    @Transient
    private String mensajeNivelAcceso;

    @Transient
    private boolean restriccionDocumentoNivelAcceso;

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        /*
            2017-11-10 edison.gonzalez@controltechcg.com Issue #131 (SICDI-Controltech) 
            feature-131: Cambio en la entidad usuario, se coloca llave foranea el grado.
         */
        if (usuGrado != null && !AppConstants.SIN_GRADO.equals(usuGrado.getId())) {
            b.append(usuGrado.getId()).append(". ");
        }
        b.append(nombre);
        return b.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login.trim().toLowerCase();
        } else {
            this.login = null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Integer getUma() {
        return uma;
    }

    public void setUma(Integer uma) {
        this.uma = uma;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getImagenFirma() {
        return imagenFirma;
    }

    public void setImagenFirma(String imagenFirma) {
        this.imagenFirma = imagenFirma;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean usuarioTieneFirmaCargada() {
        return imagenFirma != null && imagenFirma.trim().length() > 0;
    }

    public String getImagenFirmaExtension() {
        return imagenFirmaExtension;
    }

    public void setImagenFirmaExtension(String imagenFirmaExtension) {
        this.imagenFirmaExtension = imagenFirmaExtension;
    }

    public String getMensajeNivelAcceso() {
        return mensajeNivelAcceso;
    }

    public void setMensajeNivelAcceso(String mensajeNivelAcceso) {
        this.mensajeNivelAcceso = mensajeNivelAcceso;
    }

    public boolean isRestriccionDocumentoNivelAcceso() {
        return restriccionDocumentoNivelAcceso;
    }

    public void setRestriccionDocumentoNivelAcceso(boolean restriccionDocumentoNivelAcceso) {
        this.restriccionDocumentoNivelAcceso = restriccionDocumentoNivelAcceso;
    }

    @Transient
    private String idString;

    public String getIdString() {
        if (id != null) {
            idString = id.toString().replaceAll("\\.", "");
        } else {
            idString = null;
        }
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public Grados getUsuGrado() {
        return usuGrado;
    }

    public void setUsuGrado(Grados usuGrado) {
        this.usuGrado = usuGrado;
    }

    public Cargo getUsuCargo7Id() {
        return usuCargo7Id;
    }

    public void setUsuCargo7Id(Cargo usuCargo7Id) {
        this.usuCargo7Id = usuCargo7Id;
    }

    public Cargo getUsuCargo10Id() {
        return usuCargo10Id;
    }

    public void setUsuCargo10Id(Cargo usuCargo10Id) {
        this.usuCargo10Id = usuCargo10Id;
    }

    public Cargo getUsuCargo9Id() {
        return usuCargo9Id;
    }

    public void setUsuCargo9Id(Cargo usuCargo9Id) {
        this.usuCargo9Id = usuCargo9Id;
    }

    public Cargo getUsuCargo8Id() {
        return usuCargo8Id;
    }

    public void setUsuCargo8Id(Cargo usuCargo8Id) {
        this.usuCargo8Id = usuCargo8Id;
    }

    public Cargo getUsuCargo6Id() {
        return usuCargo6Id;
    }

    public void setUsuCargo6Id(Cargo usuCargo6Id) {
        this.usuCargo6Id = usuCargo6Id;
    }

    public Cargo getUsuCargo5Id() {
        return usuCargo5Id;
    }

    public void setUsuCargo5Id(Cargo usuCargo5Id) {
        this.usuCargo5Id = usuCargo5Id;
    }

    public Cargo getUsuCargo4Id() {
        return usuCargo4Id;
    }

    public void setUsuCargo4Id(Cargo usuCargo4Id) {
        this.usuCargo4Id = usuCargo4Id;
    }

    public Cargo getUsuCargo3Id() {
        return usuCargo3Id;
    }

    public void setUsuCargo3Id(Cargo usuCargo3Id) {
        this.usuCargo3Id = usuCargo3Id;
    }

    public Cargo getUsuCargo2Id() {
        return usuCargo2Id;
    }

    public void setUsuCargo2Id(Cargo usuCargo2Id) {
        this.usuCargo2Id = usuCargo2Id;
    }

    public Cargo getUsuCargo1Id() {
        return usuCargo1Id;
    }

    public void setUsuCargo1Id(Cargo usuCargo1Id) {
        this.usuCargo1Id = usuCargo1Id;
    }

    public Cargo getUsuCargoPrincipalId() {
        return usuCargoPrincipalId;
    }

    public void setUsuCargoPrincipalId(Cargo usuCargoPrincipalId) {
        this.usuCargoPrincipalId = usuCargoPrincipalId;
    }
}
