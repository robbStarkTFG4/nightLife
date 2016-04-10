/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcoisaac
 */
@Entity
@Table(name = "historial_reservaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialReservaciones.findAll", query = "SELECT h FROM HistorialReservaciones h"),
    @NamedQuery(name = "HistorialReservaciones.findByIdhistorialReservaciones", query = "SELECT h FROM HistorialReservaciones h WHERE h.idhistorialReservaciones = :idhistorialReservaciones"),
    @NamedQuery(name = "HistorialReservaciones.findByStatus", query = "SELECT h FROM HistorialReservaciones h WHERE h.status = :status"),
    @NamedQuery(name = "HistorialReservaciones.findByFechaSolicitud", query = "SELECT h FROM HistorialReservaciones h WHERE h.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "HistorialReservaciones.findByFechaVencimiento", query = "SELECT h FROM HistorialReservaciones h WHERE h.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "HistorialReservaciones.findByFechaAsistido", query = "SELECT h FROM HistorialReservaciones h WHERE h.fechaAsistido = :fechaAsistido")})
public class HistorialReservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistorial_reservaciones")
    private Integer idhistorialReservaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "fecha_asistido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsistido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historialReservacionesIdhistorialReservaciones")
    private List<Review> reviewList;
    @JoinColumns({
        @JoinColumn(name = "reservaciones_disponibles_idreservaciones_disponibles", referencedColumnName = "idreservaciones_disponibles"),
        @JoinColumn(name = "reservaciones_disponibles_antro_idantro", referencedColumnName = "antro_idantro")})
    @ManyToOne(optional = false)
    private ReservacionesDisponibles reservacionesDisponibles;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;
    @OneToMany(mappedBy = "historialReservacionesIdhistorialReservaciones")
    private List<Promociones> promocionesList;

    public HistorialReservaciones() {
    }

    public HistorialReservaciones(Integer idhistorialReservaciones) {
        this.idhistorialReservaciones = idhistorialReservaciones;
    }

    public HistorialReservaciones(Integer idhistorialReservaciones, int status) {
        this.idhistorialReservaciones = idhistorialReservaciones;
        this.status = status;
    }

    public Integer getIdhistorialReservaciones() {
        return idhistorialReservaciones;
    }

    public void setIdhistorialReservaciones(Integer idhistorialReservaciones) {
        this.idhistorialReservaciones = idhistorialReservaciones;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaAsistido() {
        return fechaAsistido;
    }

    public void setFechaAsistido(Date fechaAsistido) {
        this.fechaAsistido = fechaAsistido;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public ReservacionesDisponibles getReservacionesDisponibles() {
        return reservacionesDisponibles;
    }

    public void setReservacionesDisponibles(ReservacionesDisponibles reservacionesDisponibles) {
        this.reservacionesDisponibles = reservacionesDisponibles;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @XmlTransient
    public List<Promociones> getPromocionesList() {
        return promocionesList;
    }

    public void setPromocionesList(List<Promociones> promocionesList) {
        this.promocionesList = promocionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorialReservaciones != null ? idhistorialReservaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialReservaciones)) {
            return false;
        }
        HistorialReservaciones other = (HistorialReservaciones) object;
        if ((this.idhistorialReservaciones == null && other.idhistorialReservaciones != null) || (this.idhistorialReservaciones != null && !this.idhistorialReservaciones.equals(other.idhistorialReservaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.HistorialReservaciones[ idhistorialReservaciones=" + idhistorialReservaciones + " ]";
    }
    
}
