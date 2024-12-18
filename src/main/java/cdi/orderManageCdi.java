/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.OrderManage;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "orderManageCdi")
@RequestScoped
public class orderManageCdi {
    
    @EJB adminLocal al;
    
    OrderManage om = new OrderManage();
    Collection<OrderManage> orderManage;

    /**
     * Creates a new instance of orderManageCdi
     */
    public orderManageCdi() {
    }

    public OrderManage getOm() {
        return om;
    }

    public void setOm(OrderManage om) {
        this.om = om;
    }

    public Collection<OrderManage> getOrderManage() {
        return orderManage;
    }

    public void setOrderManage(Collection<OrderManage> orderManage) {
        this.orderManage = orderManage;
    }
    
    
    
}
