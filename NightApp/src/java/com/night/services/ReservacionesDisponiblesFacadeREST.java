/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.night.services;

import com.night.entity.ReservacionesDisponibles;
import com.night.entity.ReservacionesDisponiblesPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author marcoisaac
 */
@Stateless
@Path("com.night.entity.reservacionesdisponibles")
public class ReservacionesDisponiblesFacadeREST extends AbstractFacade<ReservacionesDisponibles> {

    @PersistenceContext(unitName = "NightAppPU")
    private EntityManager em;

    private ReservacionesDisponiblesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idreservacionesDisponibles=idreservacionesDisponiblesValue;antroIdantro=antroIdantroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.night.entity.ReservacionesDisponiblesPK key = new com.night.entity.ReservacionesDisponiblesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idreservacionesDisponibles = map.get("idreservacionesDisponibles");
        if (idreservacionesDisponibles != null && !idreservacionesDisponibles.isEmpty()) {
            key.setIdreservacionesDisponibles(new java.lang.Integer(idreservacionesDisponibles.get(0)));
        }
        java.util.List<String> antroIdantro = map.get("antroIdantro");
        if (antroIdantro != null && !antroIdantro.isEmpty()) {
            key.setAntroIdantro(new java.lang.Integer(antroIdantro.get(0)));
        }
        return key;
    }

    public ReservacionesDisponiblesFacadeREST() {
        super(ReservacionesDisponibles.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ReservacionesDisponibles entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ReservacionesDisponibles entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.night.entity.ReservacionesDisponiblesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReservacionesDisponibles find(@PathParam("id") PathSegment id) {
        com.night.entity.ReservacionesDisponiblesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReservacionesDisponibles> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReservacionesDisponibles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
