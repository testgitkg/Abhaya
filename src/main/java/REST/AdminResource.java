/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.adminLocal;
import entity.Role;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author 1
 */
@Path("Admin")
@RequestScoped
public class AdminResource {

    @EJB adminLocal ab;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    /**
     * Retrieves representation of an instance of REST.AdminResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    //role
    @GET
    @Path("/rolebyid/{rid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getRoleById(@PathParam("rid")Integer rid) {
        return ab.getRoleById(rid);
    }
    
    @POST
    @Path("/addrole/{roleName}")
    public void addRole(@PathParam("roleName")String role_name) {
        ab.addRole(role_name);
    }
    
    @PUT
    @Path("/updaterole/{rid}/{roleName}")
    public void updateRole(@PathParam("rid")Integer rid, @PathParam("roleName")String role_name) {
        ab.updateRole(rid, role_name);
    }
    
    @DELETE
     @Path("/deleterole/{rid}")
     public void deleteRole(@PathParam("rid")Integer rid) {
         ab.deleteRole(rid);
     } 
     
//    @POST
//    @Path("/addadmin/{aname}/{email}/{password}/{rid}")
//    public void addAdmin(@PathParam("aname")String aname, @String email, String password, Integer rid) {
//        ab.addAdmin(aname, email, password, rid);
//    }
        
    
}
