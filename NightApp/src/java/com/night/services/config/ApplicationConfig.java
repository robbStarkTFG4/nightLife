/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.services.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author marcoisaac
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.night.services.AmigosFacadeREST.class);
        resources.add(com.night.services.AntroFacadeREST.class);
        resources.add(com.night.services.HistorialReservacionesFacadeREST.class);
        resources.add(com.night.services.PreguntaFacadeREST.class);
        resources.add(com.night.services.PromocionesFacadeREST.class);
        resources.add(com.night.services.ReservacionesDisponiblesFacadeREST.class);
        resources.add(com.night.services.ReviewFacadeREST.class);
        resources.add(com.night.services.TestPersonalidadFacadeREST.class);
        resources.add(com.night.services.UsuarioFacadeREST.class);
        resources.add(com.night.services.config.GenericResource.class);
    }
    
}
