/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.userClient;
import entity.Cart;
import entity.UserMst;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Named(value = "cartCdi")
@SessionScoped
public class cartCdi implements Serializable {
    
    userClient uc;
    Response rs;
    Cart c;
    UserMst u;
    
    Integer cartid;
    Integer uid;
    Date created_at;
    Date updated_at;
    String status;
    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;

    /**
     * Creates a new instance of cartCdi
     */
    public cartCdi() {
        uc = new userClient();
        cart = new ArrayList<>();
        gcart = new GenericType<Collection<Cart>>(){};
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        c = new Cart();
        u = new UserMst();
    }

    public String addCart(){
        uc.addCart(String.valueOf(uid), status);
        return "cart.xhtml";
    }
    
    public String updateCart(){
        cartid = c.getCartid();
        u = c.getUid();
        created_at = c.getCreatedAt();
        updated_at = c.getUpdatedAt();
        status = c.getStatus();
        
        uc.updateCart(String.valueOf(cartid), String.valueOf(uid), status);
        c = new Cart();
        return "cart.xhtml";
    }
    
    public String deleteCart(){
        uc.deleteCart(String.valueOf(cartid));
        return "cart.xhtml";
    }
    
    public Collection<Cart> getAllCart(){
        rs = uc.getAllCart(Response.class);
        cart = rs.readEntity(gcart);
        return cart;
    }
    
    public String redirectToUpdate(){
        return "cartUpdate.xhtml";
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

    public Cart getC() {
        return c;
    }

    public void setC(Cart c) {
        this.c = c;
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Cart> getCart() {
        return cart;
    }

    public void setCart(Collection<Cart> cart) {
        this.cart = cart;
    }

    public GenericType<Collection<Cart>> getGcart() {
        return gcart;
    }

    public void setGcart(GenericType<Collection<Cart>> gcart) {
        this.gcart = gcart;
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
   
    
}
