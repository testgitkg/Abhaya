/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.userLocal;
import entity.OrderItem;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "orderItemCdi")
@RequestScoped
public class orderItemCdi {
    
    @EJB userLocal ul;
    
    OrderItem oi = new OrderItem();
    Collection<OrderItem> orderItem;

    /**
     * Creates a new instance of orderItemCdi
     */
    public orderItemCdi() {
    }

    public OrderItem getOi() {
        return oi;
    }

    public void setOi(OrderItem oi) {
        this.oi = oi;
    }

    public Collection<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Collection<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
    
    
    
}
