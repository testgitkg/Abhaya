/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import client.userClient;
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
@Named(value = "registerCdi")
@SessionScoped
public class registerCdi implements Serializable {
    
    userClient uc;
    adminClient ac;
    Response rs;
    UserMst u;
    Role r;
    
    Integer uid;
    String uname;
    String email;
    String password;
    String address;
    Integer rid;
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;
    
    Collection<Role> role;
    GenericType<Collection<Role>> grole;

    /**
     * Creates a new instance of register
     */
    public registerCdi() {
        uc = new userClient();
        ac = new adminClient();
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        role = new ArrayList<>();
        grole = new GenericType<Collection<Role>>(){};
        u = new UserMst();
        r = new Role();
    }

    public String addUserMst(){
        uc.addUserMst(uname, email, password, address, String.valueOf(rid));
        return "home.xhtml?faces-redirect=true";
    }
    
    public String updateUserMst(){
        uc.updateUserMst(String.valueOf(u.getUid()), u.getUname(), u.getEmail(),
                u.getPassword(), u.getAddress(), String.valueOf(u.getRid().getRid()));
        u = new UserMst();
        return "register.xhtml";
    }
    
    public String deleteUserMst(){
        uc.deleteUserMst(String.valueOf(uid));
        return "register.xhtml";
    }
    
    public Collection<UserMst> getAllUsers(){
        rs = uc.getAllUserMst(Response.class);
        user = rs.readEntity(guser);
        return user;
    }
    
    public String redirectToUpdate(){
        return "registerInsert.xhtml?faces-redirect=true";
    }
    
    
    
//    login
    
    public String login(){
        rs = ac.getAllUsers(Response.class);
        user = rs.readEntity(guser);
        
        for(UserMst us : user){
            if(us.getEmail().equals(email) && us.getPassword().equals(password) ){
                this.uid = us.getUid();
                this.uname = us.getUname();
                this.email = us.getEmail();
                this.address = us.getAddress();
                this.r = us.getRid();
                
                if("admin".equalsIgnoreCase(r.getRoleName()) ){
                    return "/faces/homeAdmin.xhtml?faces-redirect=true";
                }
                else{
                    return "/faces/home.xhtml?faces-redirect=true";
                }
            }
        }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid username or password"));
        return "login.xhtml";
    }
    
//    log out
    
//    public String logout() {
//        // Invalidate the current session
////        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//
//        // Redirect to the login page
//        return "../faces/login.xhtml?faces-redirect=true";
//    }


    
    public userClient getUc() {
        return uc;
    }
    
    public void setUc(userClient uc) {
        this.uc = uc;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
    }

    public Role getR() {
        return r;
    }

    public void setR(Role r) {
        this.r = r;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Collection<UserMst> getUser() {
        return user;
    }

    public void setUser(Collection<UserMst> user) {
        this.user = user;
    }

    public GenericType<Collection<UserMst>> getGuser() {
        return guser;
    }

    public void setGuser(GenericType<Collection<UserMst>> guser) {
        this.guser = guser;
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

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }
       public String redirectToRegister() {
        // Redirect to the desired page
        return "registerInsert?faces-redirect=true";
    }  
    
}
