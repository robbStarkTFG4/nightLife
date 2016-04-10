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
public class TestPersonalidadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idtest_personalidad")
    private int idtestPersonalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idusuario")
    private int usuarioIdusuario;

    public TestPersonalidadPK() {
    }

    public TestPersonalidadPK(int idtestPersonalidad, int usuarioIdusuario) {
        this.idtestPersonalidad = idtestPersonalidad;
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getIdtestPersonalidad() {
        return idtestPersonalidad;
    }

    public void setIdtestPersonalidad(int idtestPersonalidad) {
        this.idtestPersonalidad = idtestPersonalidad;
    }

    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtestPersonalidad;
        hash += (int) usuarioIdusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestPersonalidadPK)) {
            return false;
        }
        TestPersonalidadPK other = (TestPersonalidadPK) object;
        if (this.idtestPersonalidad != other.idtestPersonalidad) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.TestPersonalidadPK[ idtestPersonalidad=" + idtestPersonalidad + ", usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
