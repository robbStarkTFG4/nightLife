/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdpregunta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.idpregunta = :idpregunta"),
    @NamedQuery(name = "Pregunta.findByRespuesta", query = "SELECT p FROM Pregunta p WHERE p.respuesta = :respuesta"),
    @NamedQuery(name = "Pregunta.findByTestPersonalidadIdtestPersonalidad", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.testPersonalidadIdtestPersonalidad = :testPersonalidadIdtestPersonalidad"),
    @NamedQuery(name = "Pregunta.findByTestPersonalidadUsuarioIdusuario", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.testPersonalidadUsuarioIdusuario = :testPersonalidadUsuarioIdusuario"),
    @NamedQuery(name = "Pregunta.findByNumPregunta", query = "SELECT p FROM Pregunta p WHERE p.numPregunta = :numPregunta")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreguntaPK preguntaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numPregunta")
    private int numPregunta;
    @JoinColumns({
        @JoinColumn(name = "test_personalidad_idtest_personalidad", referencedColumnName = "idtest_personalidad", insertable = false, updatable = false),
        @JoinColumn(name = "test_personalidad_usuario_idusuario", referencedColumnName = "usuario_idusuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TestPersonalidad testPersonalidad;

    public Pregunta() {
    }

    public Pregunta(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Pregunta(PreguntaPK preguntaPK, String respuesta, int numPregunta) {
        this.preguntaPK = preguntaPK;
        this.respuesta = respuesta;
        this.numPregunta = numPregunta;
    }

    public Pregunta(int idpregunta, int testPersonalidadIdtestPersonalidad, int testPersonalidadUsuarioIdusuario) {
        this.preguntaPK = new PreguntaPK(idpregunta, testPersonalidadIdtestPersonalidad, testPersonalidadUsuarioIdusuario);
    }

    public PreguntaPK getPreguntaPK() {
        return preguntaPK;
    }

    public void setPreguntaPK(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getNumPregunta() {
        return numPregunta;
    }

    public void setNumPregunta(int numPregunta) {
        this.numPregunta = numPregunta;
    }

    public TestPersonalidad getTestPersonalidad() {
        return testPersonalidad;
    }

    public void setTestPersonalidad(TestPersonalidad testPersonalidad) {
        this.testPersonalidad = testPersonalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.night.entity.Pregunta[ preguntaPK=" + preguntaPK + " ]";
    }
    
}
