package com.douwe.notes.resource;

import com.douwe.notes.entities.Inscription;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Path("/inscriptions")
public interface IInscriptionResource {
    
    @POST
    @Produces(value = "application/json") 
    Inscription createInscription(Inscription inscription);

    @GET
    @Produces(value = "application/json")
    List<Inscription> getAllInscriptions();

    @GET
    @Path(value = "{id : \\d+}")
    @Produces(value = "application/json")
    Inscription getInscription(@PathParam(value = "id")long id);

    @PUT
    @Path(value = "{id : \\d+}")
    @Produces(value = "application/json")
    Inscription updateInscription(@PathParam(value = "id")long id, Inscription inscription);

    @DELETE
    @Path(value = "{id : \\d+}")
    void deleteInscription(@PathParam(value = "id")long id);
}
