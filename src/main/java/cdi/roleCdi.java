
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Role;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "roleCdi")
@RequestScoped
public class roleCdi {
    
    adminClient ac;
    Response rs;
    Role r;
    
    Integer rid;
    String role_name;
    Collection<Role> role;
    GenericType<Collection<Role>> grole;
    

    /**
     * Creates a new instance of roleCdi
     */
    public roleCdi() {
        ac = new adminClient();
        role = new ArrayList<>();
        grole = new GenericType<Collection<Role>>(){};
        r = new Role();
        
    }
    
    public String addRole(){
        try{
        ac.addRole(role_name);
        return "role.xhtml";
        }
        catch(Exception e){
             e.printStackTrace();
               return "failure";
        }
    }
    
    public String updateRole(){
        rid = r.getRid();
        role_name = r.getRoleName();
        
        ac.updateRole(String.valueOf(rid),role_name);
        r = new Role();
        return "role.xhtml";
    }
    
    public String deleteRole(){
        ac.deleteRole(String.valueOf(rid));
        return "role.xhtml";
    }
    
    public Collection<Role> getAllRoles(){
        rs = ac.getAllRoles(Response.class);
        role = rs.readEntity(grole);
        return role;
    }
    
    public String redirectToUpdate(){
        return "roleUpdate.xhtml";
    }
    

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }

    public GenericType<Collection<Role>> getGrole() {
        return grole;
    }

    public void setGrole(GenericType<Collection<Role>> grole) {
        this.grole = grole;
    }
    
    
    
}
