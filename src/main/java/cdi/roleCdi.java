/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Role;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "roleCdi")
@RequestScoped
public class roleCdi {
    
    @EJB adminLocal al;
    
    Role r = new Role();
    Collection<Role> role;

    /**
     * Creates a new instance of roleCdi
     */
    public roleCdi() {
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }
    
    public String addRole(){
        al.addRole(r.getRoleName());
        r = new Role();
        return "index";
    }
    
    public String updateRole(Integer rid, String role_name){
        rid = r.getRid();
        role_name = r.getRoleName();
        al.updateRole(rid, role_name);
        return "index";
    }
    
    public void deleteRole(Integer rid){
        al.deleteRole(rid);
    }
    
    public Collection<Role> getAllRoles(){
        return al.getAllRoles();
    }
    
    
    
    
    
}
