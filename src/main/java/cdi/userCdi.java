/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import ejb.userLocal;
import entity.Role;
import entity.UserMst;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author abhaya
 */
@Named(value = "userCdi")
@SessionScoped
public class userCdi implements Serializable {
    
    @EJB adminLocal al;
    @EJB userLocal ul;
   
    UserMst u = new UserMst();
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;
    String uname;
    String email;
    String password;
    String address;
    Integer rid;
    
    Collection<Role> role;
    GenericType<Collection<Role>> grole;

    /**
     * Creates a new instance of userCdi
     */
    public userCdi() {
        user = new ArrayList<>();
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

    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }

    
    
    

    public Collection<UserMst> getUser() {
        return user;
    }

    public void setUser(Collection<UserMst> user) {
        this.user = user;
    }

    
    
    public String addUserMst(){
        ul.addUserMst(uname, email, password, address, rid);
        u = new UserMst();
        return "index";
    }
    
    public void deleteUser(Integer uid, Integer rid){
        ul.deleteUserMst(uid, rid);
    }
    
    public Collection<UserMst> getAllUsers(){
        return al.getAllUsers();
    }
    
}
