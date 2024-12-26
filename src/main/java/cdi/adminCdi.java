/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Admin;
import entity.Role;
import entity.UserMst;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "adminCdi")
@SessionScoped
public class adminCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    Admin a;
    Role r;
    
    Integer aid;
    String aname;
    String email;
    String password;
    Integer rid;
    Collection<Admin> admin;
    GenericType<Collection<Admin>> gadmin;
    
    Collection<Role> role;
    GenericType<Collection<Role>> grole;

    /**
     * Creates a new instance of adminCdi
     */
    public adminCdi() {
        ac = new adminClient();
        admin = new ArrayList<>();
        gadmin = new GenericType<Collection<Admin>>(){};
        role = new ArrayList<>();
        grole = new GenericType<Collection<Role>>(){};
        a = new Admin();
        r = new Role();
    }
    
    public String addAdmin(){
        ac.addAdmin(aname, email, password, String.valueOf(rid));
        return "admin.xhtml";
    }
   
    public String updateAdmin(){
        aid = a.getAid();
        aname = a.getAname();
        email = a.getEmail();
        password = a.getPassword();
        r = a.getRid();
        
        ac.updateAdmin(String.valueOf(aid), aname, email, password, String.valueOf(rid));
        a = new Admin();
        return "admin.xhtml";
    }
    
    public String deleteAdmin(){
        ac.deleteAdmin(String.valueOf(aid));
        return "admin.xhtml";
    }
    
    public Collection<Admin> getAllAdmin(){
        rs = ac.getAllAdmin(Response.class);
        admin = rs.readEntity(gadmin);
        return admin;
    }
    
    public String redirectToUpdate(){
        return "adminUpdate.xhtml";
    }
    
//    public String login(){
//        rs = ac.getAllAdmin(Response.class);
//        admin = rs.readEntity(gadmin);
//        
//        for(Admin ad : admin){
//            if(ad.getEmail().equals(email) && ad.getPassword().equals(password) ){
//                this.aid = ad.getAid();
//                this.aname = ad.getAname();
//                this.email = ad.getEmail();
//                this.r = ad.getRid();
//                
//                if("admin".equalsIgnoreCase(r.getRoleName()) ){
//                    return "/faces/homeAdmin.xhtml?faces-redirect=true";
//                }
//                else{
//                    return "/faces/home.xhtml?faces-redirect=true";
//                }
//            }
//        }
//        
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid username or password"));
//        return "login.xhtml";
//    }

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

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Collection<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(Collection<Admin> admin) {
        this.admin = admin;
    }

    public GenericType<Collection<Admin>> getGadmin() {
        return gadmin;
    }

    public void setGadmin(GenericType<Collection<Admin>> gadmin) {
        this.gadmin = gadmin;
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
