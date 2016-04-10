/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marcoisaac
 */
@Embeddable
public class PreguntaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idpregunta")
    private int idpregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "test_personalidad_idtest_personalidad")
    private int testPersonalidadIdtestPersonalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "test_personalidad_usuario_idusuario")
    private int testPersonalidadUsuarioIdusuario;

    public PreguntaPK() {
    }

    public PreguntaPK(int idpregunta, int testPersonalidadIdtestPersonalidad, int testPersonalidadUsuarioIdusuario) {
        this.idpregunta = idpregunta;
        this.testPersonalidadIdtestPersonalidad = testPersonalidadIdtestPersonalidad;
        this.testPersonalidadUsuarioIdusuario = testPersonalidadUsuarioIdusuario;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public int getTestPersonalidadIdtestPersonalidad() {
        return testPersonalidadIdtestPersonalidad;
    }

    public void setTestPersonalidadIdtestPersonalidad(int testPersonalidadIdtestPersonalidad) {
        this.testPersonalidadIdtestPersonalidad = testPersonalidadIdtestPersonalidad;
    }

    public int getTestPersonalidadUsuarioIdusuario() {
        return testPersonalidadUsuarioIdusuario;
    }

    public void setTestPersonalidadUsuarioIdusuario(int testPersonalidadUsuarioIdusuario) {
        this.testPersonalidadUsuarioIdusuario = testPersonalidadUsuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpregunta;
        hash += (int) testPersonalidadIdtestPersonalidad;
        hash += (int) testPersonalidadUsuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK)) {
            return false;
        }
        PreguntaPK other = (PreguntaPK) object;
        if (this.idpregunta != other.idpregunta) {
            return false;
        }
        if (this.testPersonalidadIdtestPersonalidad != other.testPersonalidadIdtestPersonalidad) {
            return false;
        }
        if (this.testPersonalidadUsuarioIdusuario != other.testPersonalidadUsuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.PreguntaPK[ idpregunta=" + idpregunta + ", testPersonalidadIdtestPersonalidad=" + testPersonalidadIdtestPersonalidad + ", testPersonalidadUsuarioIdusuario=" + testPersonalidadUsuarioIdusuario + " ]";
    }
    
}
