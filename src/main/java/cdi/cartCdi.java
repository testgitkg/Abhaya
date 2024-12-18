
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.userLocal;
import entity.Cart;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "cartCdi")
@RequestScoped
public class cartCdi {
    
    @EJB userLocal ul;
    
    Cart c = new Cart();
    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;
    Integer uid;
    String status;
    

    /**
     * Creates a new instance of cartCdi
     */
    public cartCdi() {
    }

    public Cart getC() {
        return c;
    }

    public void setC(Cart c) {
        this.c = c;
    }

    public Collection<Cart> getCart() {
        return cart;
    }

    public void setCart(Collection<Cart> cart) {
        this.cart = cart;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String addCart(){
        ul.addCart(uid, status);
        return "cart.xhtml";
    }
    
    public String updateCart(){
        
        return "cart.xhtml";
    }
    
    public void deleteCart(Integer cartid, Integer uid){
        ul.deleteCart(cartid, uid);
    }
    
    public Collection<Cart> getAllCart(){
        return ul.getAllCart();
    }
    
    
}
