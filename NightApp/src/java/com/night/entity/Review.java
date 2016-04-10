/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcoisaac
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByIdreview", query = "SELECT r FROM Review r WHERE r.idreview = :idreview"),
    @NamedQuery(name = "Review.findByComentario", query = "SELECT r FROM Review r WHERE r.comentario = :comentario"),
    @NamedQuery(name = "Review.findByCalificasion", query = "SELECT r FROM Review r WHERE r.calificasion = :calificasion"),
    @NamedQuery(name = "Review.findByIdAntro", query = "SELECT r FROM Review r WHERE r.idAntro = :idAntro")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreview")
    private Integer idreview;
    @Size(max = 300)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "calificasion")
    private Integer calificasion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAntro")
    private int idAntro;
    @JoinColumn(name = "historial_reservaciones_idhistorial_reservaciones", referencedColumnName = "idhistorial_reservaciones")
    @ManyToOne(optional = false)
    private HistorialReservaciones historialReservacionesIdhistorialReservaciones;

    public Review() {
    }

    public Review(Integer idreview) {
        this.idreview = idreview;
    }

    public Review(Integer idreview, int idAntro) {
        this.idreview = idreview;
        this.idAntro = idAntro;
    }

    public Integer getIdreview() {
        return idreview;
    }

    public void setIdreview(Integer idreview) {
        this.idreview = idreview;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getCalificasion() {
        return calificasion;
    }

    public void setCalificasion(Integer calificasion) {
        this.calificasion = calificasion;
    }

    public int getIdAntro() {
        return idAntro;
    }

    public void setIdAntro(int idAntro) {
        this.idAntro = idAntro;
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
        hash += (idreview != null ? idreview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.idreview == null && other.idreview != null) || (this.idreview != null && !this.idreview.equals(other.idreview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.Review[ idreview=" + idreview + " ]";
    }
    
}
