/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.CartItem;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "cartItmCdi")
@RequestScoped
public class cartItmCdi {
    
    @EJB adminLocal al;
    
    CartItem ci = new CartItem();
    Collection<CartItem> cartItem;

    /**
     * Creates a new instance of cartItmCdi
     */
    public cartItmCdi() {
    }

    public CartItem getCi() {
        return ci;
    }

    public void setCi(CartItem ci) {
        this.ci = ci;
    }

    public Collection<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Collection<CartItem> cartItem) {
        this.cartItem = cartItem;
    }
    
    
    
}
