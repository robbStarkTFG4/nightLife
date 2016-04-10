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
@Table(name = "antro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antro.findAll", query = "SELECT a FROM Antro a"),
    @NamedQuery(name = "Antro.findByIdantro", query = "SELECT a FROM Antro a WHERE a.idantro = :idantro"),
    @NamedQuery(name = "Antro.findByDireccion1", query = "SELECT a FROM Antro a WHERE a.direccion1 = :direccion1"),
    @NamedQuery(name = "Antro.findByDireccion2", query = "SELECT a FROM Antro a WHERE a.direccion2 = :direccion2"),
    @NamedQuery(name = "Antro.findByContacto", query = "SELECT a FROM Antro a WHERE a.contacto = :contacto"),
    @NamedQuery(name = "Antro.findByDescripcion", query = "SELECT a FROM Antro a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Antro.findByDressCode", query = "SELECT a FROM Antro a WHERE a.dressCode = :dressCode"),
    @NamedQuery(name = "Antro.findByHorario", query = "SELECT a FROM Antro a WHERE a.horario = :horario"),
    @NamedQuery(name = "Antro.findByPromedioCalificacion", query = "SELECT a FROM Antro a WHERE a.promedioCalificacion = :promedioCalificacion"),
    @NamedQuery(name = "Antro.findByNombre", query = "SELECT a FROM Antro a WHERE a.nombre = :nombre")})
public class Antro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idantro")
    private Integer idantro;
    @Size(max = 70)
    @Column(name = "direccion1")
    private String direccion1;
    @Size(max = 70)
    @Column(name = "direccion2")
    private String direccion2;
    @Size(max = 100)
    @Column(name = "contacto")
    private String contacto;
    @Size(max = 600)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "dress_code")
    private String dressCode;
    @Size(max = 400)
    @Column(name = "horario")
    private String horario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "promedio_calificacion")
    private Double promedioCalificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    public Antro() {
    }

    public Antro(Integer idantro) {
        this.idantro = idantro;
    }

    public Antro(Integer idantro, String nombre) {
        this.idantro = idantro;
        this.nombre = nombre;
    }

    public Integer getIdantro() {
        return idantro;
    }

    public void setIdantro(Integer idantro) {
        this.idantro = idantro;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(Double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idantro != null ? idantro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antro)) {
            return false;
        }
        Antro other = (Antro) object;
        if ((this.idantro == null && other.idantro != null) || (this.idantro != null && !this.idantro.equals(other.idantro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.Antro[ idantro=" + idantro + " ]";
    }
    
}
