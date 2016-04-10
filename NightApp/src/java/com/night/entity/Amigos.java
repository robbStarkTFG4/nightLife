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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcoisaac
 */
@Entity
@Table(name = "amigos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigos.findAll", query = "SELECT a FROM Amigos a"),
    @NamedQuery(name = "Amigos.findByIdamigos", query = "SELECT a FROM Amigos a WHERE a.idamigos = :idamigos"),
    @NamedQuery(name = "Amigos.findByUsuario", query = "SELECT a FROM Amigos a WHERE a.usuario = :usuario")})
public class Amigos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idamigos")
    private Integer idamigos;
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Amigos() {
    }

    public Amigos(Integer idamigos) {
        this.idamigos = idamigos;
    }

    public Integer getIdamigos() {
        return idamigos;
    }

    public void setIdamigos(Integer idamigos) {
        this.idamigos = idamigos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idamigos != null ? idamigos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigos)) {
            return false;
        }
        Amigos other = (Amigos) object;
        if ((this.idamigos == null && other.idamigos != null) || (this.idamigos != null && !this.idamigos.equals(other.idamigos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.Amigos[ idamigos=" + idamigos + " ]";
    }
    
}
