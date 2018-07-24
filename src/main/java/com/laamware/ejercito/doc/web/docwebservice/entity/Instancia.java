package com.laamware.ejercito.doc.web.docwebservice.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.laamware.ejercito.doc.web.docwebservice.serv.ProcesoService;

@Entity
@Table(name = "PROCESO_INSTANCIA")
public class Instancia extends AuditModifySupport {

    public static final String CONTEXT_NAME = "instancia";

    public static Instancia create(Integer proId) {
        Instancia x = new Instancia();
        x.id = UUID.randomUUID().toString().replaceAll("-", "");
        x.proceso = new Proceso(proId);
        return x;
    }

    @Id
    @Column(name = "PIN_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "PRO_ID")
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "PES_ID")
    private Estado estado;

    @OneToMany
    @JoinColumn(name = "PIN_ID")
    private List<Variable> variables = new ArrayList<Variable>();

    @OneToMany
    @JoinColumn(name = "PIN_ID")
    private List<Observacion> observaciones = new ArrayList<Observacion>();

    @ManyToOne
    @JoinColumn(name = "USU_ID_ASIGNADO")
    private Usuario asignado;

//    @Transient
//    private ProcesoService service;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public Map<String, String> getVariablesAsMap() {
        Map<String, String> map = new HashMap<>();
        if (variables != null) {
            for (Variable v : variables) {
                if (v.getActivo()) {
                    map.put(v.getKey(), v.getValue());
                }
            }
        }
        return map;
    }

    public Variable findVariable(String key) {
        for (Variable variable : variables) {
            if (variable.getKey().equals(key)) {
                return variable;
            }
        }
        return null;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getAsignado() {
        return asignado;
    }

    public void setAsignado(Usuario asignado) {
        this.asignado = asignado;
    }

    /**
     * Obtiene el valor de una variable de instancia
     *
     * @param key
     * @return
     */
    public String getVariable(String key) {
        Variable v = findVariable(key);
        if (v != null) {
            return v.getValue();
        }
        return null;
    }

//    public ProcesoService getService() {
//        return service;
//    }
//
//    public void setService(ProcesoService service) {
//        this.service = service;
//    }

//    public Variable setVariable(String key, String value, Integer usuId) {
//        return service.setVariable(this, key, value, usuId);
//    }

    @Override
    public String toString() {
        return "Instancia{" + "id=" + id + ", proceso=" + proceso + ", estado=" + estado + ", variables=" + variables + ", observaciones=" + observaciones + ", asignado=" + asignado + '}';
    }
    
    
}
