/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.ejb;

import com.night.entity.TestPersonalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcoisaac
 */
@Stateless
public class TestPersonalidadFacade extends AbstractFacade<TestPersonalidad> {

    @PersistenceContext(unitName = "NightAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestPersonalidadFacade() {
        super(TestPersonalidad.class);
    }
    
}
