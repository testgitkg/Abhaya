/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import ejb.userLocal;
import entity.UserMst;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "registerCdi")
@RequestScoped
public class registerCdi {
    
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

    /**
     * Creates a new instance of registerCdi
     */
    public registerCdi() {
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
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
    
    
    public String addUserMst(){
        ul.addUserMst(uname, email, password, address, rid);
        u = new UserMst();
        return "index";
    }
    
    public String updateUserMst(){
        
        return "index";
    }
    
    public void deleteUser(Integer uid, Integer rid){
        ul.deleteUserMst(uid, rid);
    }
    
    public Collection<UserMst> getAllUsers(){
        return al.getAllUsers();
    }
    
    
    
}
