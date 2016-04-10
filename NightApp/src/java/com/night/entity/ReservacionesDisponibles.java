/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcoisaac
 */
@Entity
@Table(name = "reservaciones_disponibles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservacionesDisponibles.findAll", query = "SELECT r FROM ReservacionesDisponibles r"),
    @NamedQuery(name = "ReservacionesDisponibles.findByIdreservacionesDisponibles", query = "SELECT r FROM ReservacionesDisponibles r WHERE r.reservacionesDisponiblesPK.idreservacionesDisponibles = :idreservacionesDisponibles"),
    @NamedQuery(name = "ReservacionesDisponibles.findByAntroIdantro", query = "SELECT r FROM ReservacionesDisponibles r WHERE r.reservacionesDisponiblesPK.antroIdantro = :antroIdantro"),
    @NamedQuery(name = "ReservacionesDisponibles.findByDescripcion", query = "SELECT r FROM ReservacionesDisponibles r WHERE r.descripcion = :descripcion")})
public class ReservacionesDisponibles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservacionesDisponiblesPK reservacionesDisponiblesPK;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "antro_idantro", referencedColumnName = "idantro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Antro antro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservacionesDisponibles")
    private List<HistorialReservaciones> historialReservacionesList;

    public ReservacionesDisponibles() {
    }

    public ReservacionesDisponibles(ReservacionesDisponiblesPK reservacionesDisponiblesPK) {
        this.reservacionesDisponiblesPK = reservacionesDisponiblesPK;
    }

    public ReservacionesDisponibles(int idreservacionesDisponibles, int antroIdantro) {
        this.reservacionesDisponiblesPK = new ReservacionesDisponiblesPK(idreservacionesDisponibles, antroIdantro);
    }

    public ReservacionesDisponiblesPK getReservacionesDisponiblesPK() {
        return reservacionesDisponiblesPK;
    }

    public void setReservacionesDisponiblesPK(ReservacionesDisponiblesPK reservacionesDisponiblesPK) {
        this.reservacionesDisponiblesPK = reservacionesDisponiblesPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Antro getAntro() {
        return antro;
    }

    public void setAntro(Antro antro) {
        this.antro = antro;
    }

    @XmlTransient
    public List<HistorialReservaciones> getHistorialReservacionesList() {
        return historialReservacionesList;
    }

    public void setHistorialReservacionesList(List<HistorialReservaciones> historialReservacionesList) {
        this.historialReservacionesList = historialReservacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservacionesDisponiblesPK != null ? reservacionesDisponiblesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionesDisponibles)) {
            return false;
        }
        ReservacionesDisponibles other = (ReservacionesDisponibles) object;
        if ((this.reservacionesDisponiblesPK == null && other.reservacionesDisponiblesPK != null) || (this.reservacionesDisponiblesPK != null && !this.reservacionesDisponiblesPK.equals(other.reservacionesDisponiblesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.ReservacionesDisponibles[ reservacionesDisponiblesPK=" + reservacionesDisponiblesPK + " ]";
    }
    
}
