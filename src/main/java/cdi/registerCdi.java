/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.userClient;
import entity.Role;
import entity.UserMst;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
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
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        role = new ArrayList<>();
        grole = new GenericType<Collection<Role>>(){};
        u = new UserMst();
        r = new Role();
    }

    public String addUserMst(){
        uc.addUserMst(uname, email, password, address, String.valueOf(rid));
        return "register.xhtml";
    }
    
    public String updateUserMst(){
        uid = u.getUid();
        uname = u.getUname();
        email = u.getEmail();
        password = u.getPassword();
        address = u.getAddress();
        r = u.getRid();
        
        uc.updateUserMst(String.valueOf(uid), uname, email, password, address, String.valueOf(rid));
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
        return "registerUpdate.xhtml";
    }
    
    
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
        
    
}
