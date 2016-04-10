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
public class ReservacionesDisponiblesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idreservaciones_disponibles")
    private int idreservacionesDisponibles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "antro_idantro")
    private int antroIdantro;

    public ReservacionesDisponiblesPK() {
    }

    public ReservacionesDisponiblesPK(int idreservacionesDisponibles, int antroIdantro) {
        this.idreservacionesDisponibles = idreservacionesDisponibles;
        this.antroIdantro = antroIdantro;
    }

    public int getIdreservacionesDisponibles() {
        return idreservacionesDisponibles;
    }

    public void setIdreservacionesDisponibles(int idreservacionesDisponibles) {
        this.idreservacionesDisponibles = idreservacionesDisponibles;
    }

    public int getAntroIdantro() {
        return antroIdantro;
    }

    public void setAntroIdantro(int antroIdantro) {
        this.antroIdantro = antroIdantro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idreservacionesDisponibles;
        hash += (int) antroIdantro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionesDisponiblesPK)) {
            return false;
        }
        ReservacionesDisponiblesPK other = (ReservacionesDisponiblesPK) object;
        if (this.idreservacionesDisponibles != other.idreservacionesDisponibles) {
            return false;
        }
        if (this.antroIdantro != other.antroIdantro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.ReservacionesDisponiblesPK[ idreservacionesDisponibles=" + idreservacionesDisponibles + ", antroIdantro=" + antroIdantro + " ]";
    }
    
}
