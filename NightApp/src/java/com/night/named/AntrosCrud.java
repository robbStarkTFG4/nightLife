/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.named;

import com.night.ejb.AntroFacade;
import com.night.entity.Antro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 * se encarga del crud de los antros
 *
 * @author marcoisaac
 */
@Named("nm")
@SessionScoped
public class AntrosCrud implements Serializable {

    private List<Antro> antrosList;
    private Antro antro;

    @EJB
    private AntroFacade antroFacade;

    @PostConstruct
    private void init() {
        antrosList = antroFacade.findAll();
        antro = new Antro();
    }

    /**
     * triggers sequence for antro record to be save into the DB
     *
     * @param event
     */
    public void guardarListener(ActionEvent event) {
        antroFacade.create(antro);
        antrosList.clear();
        antrosList.addAll(antroFacade.findAll());
        antro = new Antro();
        RequestContext.getCurrentInstance().update("antroForm");
    }

    // GETTERS 
    public List<Antro> getAntrosList() {
        return antrosList;
    }

    public Antro getAntro() {
        return antro;
    }

}
