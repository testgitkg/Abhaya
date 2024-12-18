/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Admin;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

/**
 *
 * @author abhaya
 */
@Named(value = "adminCdi")
@RequestScoped
public class adminCdi {
    
    @EJB adminLocal al;
    
    Admin a = new Admin();
    Collection<Admin> admin;
    GenericType<Collection<Admin>> gadmin;
    Integer rid;
    String aname;
    String email;
    String password;
    
    

    /**
     * Creates a new instance of adminCdi
     */
    public adminCdi() {
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public Collection<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(Collection<Admin> admin) {
        this.admin = admin;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    public String addAdmin(){
        al.addAdmin(aname, email, password, rid);
        a = new Admin();
        return "admin.xhtml";
    }
    
    public String updateAdmin(){
        
        return "admin.xhtml";
    }
    
    public void deleteAdmin(Integer aid, Integer rid){
        al.deleteAdmin(aid, rid);
    }
    
    public Collection<Admin> getAllAdmin(){
        return al.getAllAdmin();
    }
    
}
