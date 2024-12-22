/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Cart;
import entity.CartItem;
import entity.Medicine;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "cartItemCdi")
@SessionScoped
public class cartItemCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    CartItem ci;
    Cart c;
    Medicine m;
    
    Integer cart_item_id;
    Integer cartid;
    Integer mid;
    Integer quantity;
    BigDecimal price;
    Collection<CartItem> cartitem;
    GenericType<Collection<CartItem>> gcartitem;
    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;
    Collection<Medicine> medicine;
    GenericType<Collection<Medicine>> gmedicine;
    

    /**
     * Creates a new instance of cartItemCdi
     */
    public cartItemCdi() {
        ac = new adminClient();
        cartitem = new ArrayList<>();
        gcartitem = new GenericType<Collection<CartItem>>(){};
        cart = new ArrayList<>();
        gcart = new GenericType<Collection<Cart>>(){};
        medicine = new ArrayList<>();
        gmedicine = new GenericType<Collection<Medicine>>(){};
        ci = new CartItem();
        c = new Cart();
        m = new Medicine();
    }

    public String addCartItem(){
        ac.addCartItem(String.valueOf(cartid), String.valueOf(mid), String.valueOf(quantity), String.valueOf(price));
        return "cartItem.xhtml";
    }
    
    public String updateCartItem(){
        cart_item_id = ci.getCartItemId();
        c = ci.getCartid();
        m = ci.getMid();
        quantity = ci.getQuantity();
        price = ci.getPrice();
        
        ac.updateCartItem(String.valueOf(cart_item_id), String.valueOf(cartid), String.valueOf(mid), String.valueOf(quantity), String.valueOf(price));
        ci = new CartItem();
        return "cartItem.xhtml";
    }
    
    public String deleteCartItem(){
        ac.deleteCartItem(String.valueOf(cart_item_id));
        return "cartItem.xhtml";
    }
    
    public Collection<CartItem> getAllCartItem(){
        rs = ac.getAllCartItems(Response.class);
        cartitem = rs.readEntity(gcartitem);
        return cartitem;
    }
    
    public String redirectToUpdate(){
        return "cartItemUpdate.xhtml";
    }
    
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

    public CartItem getCi() {
        return ci;
    }

    public void setCi(CartItem ci) {
        this.ci = ci;
    }

    public Cart getC() {
        return c;
    }

    public void setC(Cart c) {
        this.c = c;
    }

    public Medicine getM() {
        return m;
    }

    public void setM(Medicine m) {
        this.m = m;
    }

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Collection<CartItem> getCartitem() {
        return cartitem;
    }

    public void setCartitem(Collection<CartItem> cartitem) {
        this.cartitem = cartitem;
    }

    public GenericType<Collection<CartItem>> getGcartitem() {
        return gcartitem;
    }

    public void setGcartitem(GenericType<Collection<CartItem>> gcartitem) {
        this.gcartitem = gcartitem;
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

    public Collection<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(Collection<Medicine> medicine) {
        this.medicine = medicine;
    }

    public GenericType<Collection<Medicine>> getGmedicine() {
        return gmedicine;
    }

    public void setGmedicine(GenericType<Collection<Medicine>> gmedicine) {
        this.gmedicine = gmedicine;
    }
    
    
}
