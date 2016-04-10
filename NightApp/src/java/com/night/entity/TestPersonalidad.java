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
@Table(name = "test_personalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestPersonalidad.findAll", query = "SELECT t FROM TestPersonalidad t"),
    @NamedQuery(name = "TestPersonalidad.findByIdtestPersonalidad", query = "SELECT t FROM TestPersonalidad t WHERE t.testPersonalidadPK.idtestPersonalidad = :idtestPersonalidad"),
    @NamedQuery(name = "TestPersonalidad.findByMusica", query = "SELECT t FROM TestPersonalidad t WHERE t.musica = :musica"),
    @NamedQuery(name = "TestPersonalidad.findByPresupuesto", query = "SELECT t FROM TestPersonalidad t WHERE t.presupuesto = :presupuesto"),
    @NamedQuery(name = "TestPersonalidad.findByUsuarioIdusuario", query = "SELECT t FROM TestPersonalidad t WHERE t.testPersonalidadPK.usuarioIdusuario = :usuarioIdusuario")})
public class TestPersonalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TestPersonalidadPK testPersonalidadPK;
    @Size(max = 1000)
    @Column(name = "musica")
    private String musica;
    @Size(max = 45)
    @Column(name = "presupuesto")
    private String presupuesto;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testPersonalidad")
    private List<Pregunta> preguntaList;

    public TestPersonalidad() {
    }

    public TestPersonalidad(TestPersonalidadPK testPersonalidadPK) {
        this.testPersonalidadPK = testPersonalidadPK;
    }

    public TestPersonalidad(int idtestPersonalidad, int usuarioIdusuario) {
        this.testPersonalidadPK = new TestPersonalidadPK(idtestPersonalidad, usuarioIdusuario);
    }

    public TestPersonalidadPK getTestPersonalidadPK() {
        return testPersonalidadPK;
    }

    public void setTestPersonalidadPK(TestPersonalidadPK testPersonalidadPK) {
        this.testPersonalidadPK = testPersonalidadPK;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testPersonalidadPK != null ? testPersonalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestPersonalidad)) {
            return false;
        }
        TestPersonalidad other = (TestPersonalidad) object;
        if ((this.testPersonalidadPK == null && other.testPersonalidadPK != null) || (this.testPersonalidadPK != null && !this.testPersonalidadPK.equals(other.testPersonalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.TestPersonalidad[ testPersonalidadPK=" + testPersonalidadPK + " ]";
    }
    
}
