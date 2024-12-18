/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import ejb.userLocal;
import entity.Order1;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "orderCdi")
@RequestScoped
public class orderCdi {
    
    @EJB adminLocal al;
    @EJB userLocal ul;
    
    Order1 o = new Order1();
    Collection<Order1> order;
    

    /**
     * Creates a new instance of orderCdi
     */
    public orderCdi() {
    }

    public Order1 getO() {
        return o;
    }

    public void setO(Order1 o) {
        this.o = o;
    }

    public Collection<Order1> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order1> order) {
        this.order = order;
    }
    
    
    public void deleteOrder(Integer oid, Integer uid){
        ul.deleteOrder(oid, uid);
    }
    
    public Collection<Order1> getAllOrders(){
        return al.getAllOrders();
    }
        
    
}
