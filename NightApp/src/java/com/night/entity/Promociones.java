/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcoisaac
 */
@Entity
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p"),
    @NamedQuery(name = "Promociones.findByIdpromociones", query = "SELECT p FROM Promociones p WHERE p.idpromociones = :idpromociones"),
    @NamedQuery(name = "Promociones.findByDescripcion", query = "SELECT p FROM Promociones p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Promociones.findByDuracion", query = "SELECT p FROM Promociones p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Promociones.findByCantidad", query = "SELECT p FROM Promociones p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Promociones.findByCantidadDisponibles", query = "SELECT p FROM Promociones p WHERE p.cantidadDisponibles = :cantidadDisponibles"),
    @NamedQuery(name = "Promociones.findByStatus", query = "SELECT p FROM Promociones p WHERE p.status = :status"),
    @NamedQuery(name = "Promociones.findByInicioPromocion", query = "SELECT p FROM Promociones p WHERE p.inicioPromocion = :inicioPromocion"),
    @NamedQuery(name = "Promociones.findByFinPromocion", query = "SELECT p FROM Promociones p WHERE p.finPromocion = :finPromocion"),
    @NamedQuery(name = "Promociones.findByCantidadMeta", query = "SELECT p FROM Promociones p WHERE p.cantidadMeta = :cantidadMeta")})
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromociones")
    private Integer idpromociones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duracion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "cantidad_disponibles")
    private Integer cantidadDisponibles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Column(name = "inicio_promocion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioPromocion;
    @Column(name = "fin_promocion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finPromocion;
    @Column(name = "cantidad_meta")
    private Integer cantidadMeta;
    @JoinColumn(name = "antro_idantro", referencedColumnName = "idantro")
    @ManyToOne(optional = false)
    private Antro antroIdantro;
    @JoinColumn(name = "historial_reservaciones_idhistorial_reservaciones", referencedColumnName = "idhistorial_reservaciones")
    @ManyToOne
    private HistorialReservaciones historialReservacionesIdhistorialReservaciones;

    public Promociones() {
    }

    public Promociones(Integer idpromociones) {
        this.idpromociones = idpromociones;
    }

    public Promociones(Integer idpromociones, String descripcion, int status) {
        this.idpromociones = idpromociones;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Integer getIdpromociones() {
        return idpromociones;
    }

    public void setIdpromociones(Integer idpromociones) {
        this.idpromociones = idpromociones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidadDisponibles() {
        return cantidadDisponibles;
    }

    public void setCantidadDisponibles(Integer cantidadDisponibles) {
        this.cantidadDisponibles = cantidadDisponibles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getInicioPromocion() {
        return inicioPromocion;
    }

    public void setInicioPromocion(Date inicioPromocion) {
        this.inicioPromocion = inicioPromocion;
    }

    public Date getFinPromocion() {
        return finPromocion;
    }

    public void setFinPromocion(Date finPromocion) {
        this.finPromocion = finPromocion;
    }

    public Integer getCantidadMeta() {
        return cantidadMeta;
    }

    public void setCantidadMeta(Integer cantidadMeta) {
        this.cantidadMeta = cantidadMeta;
    }

    public Antro getAntroIdantro() {
        return antroIdantro;
    }

    public void setAntroIdantro(Antro antroIdantro) {
        this.antroIdantro = antroIdantro;
    }

    public HistorialReservaciones getHistorialReservacionesIdhistorialReservaciones() {
        return historialReservacionesIdhistorialReservaciones;
    }

    public void setHistorialReservacionesIdhistorialReservaciones(HistorialReservaciones historialReservacionesIdhistorialReservaciones) {
        this.historialReservacionesIdhistorialReservaciones = historialReservacionesIdhistorialReservaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromociones != null ? idpromociones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.idpromociones == null && other.idpromociones != null) || (this.idpromociones != null && !this.idpromociones.equals(other.idpromociones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.Promociones[ idpromociones=" + idpromociones + " ]";
    }
    
}
