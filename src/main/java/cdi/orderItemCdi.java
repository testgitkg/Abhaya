/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.userClient;
import entity.Medicine;
import entity.Order1;
import entity.OrderItem;
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
@Named(value = "orderItemCdi")
@SessionScoped
public class orderItemCdi implements Serializable {
    
    userClient uc;
    Response rs;
    OrderItem oi;
    Order1 o;
    Medicine m;
    
    Integer order_item_id;
    Integer oid;
    Integer mid;
    Integer quantity;
    BigDecimal price;
    BigDecimal total_amt;
    Collection<OrderItem> orderitem;
    GenericType<Collection<OrderItem>> gorderitem;
    Collection<Order1> order;
    GenericType<Collection<Order1>> gorder;
    Collection<Medicine> medicine;
    GenericType<Collection<Medicine>> gmedicine;
    

    /**
     * Creates a new instance of orderItemCdi
     */
    public orderItemCdi() {
        uc = new userClient();
        orderitem = new ArrayList<>();
        gorderitem = new GenericType<Collection<OrderItem>>(){};
        order = new ArrayList<>();
        gorder = new GenericType<Collection<Order1>>(){};
        medicine = new ArrayList<>();
        gmedicine = new GenericType<Collection<Medicine>>(){};
        oi = new OrderItem();
        o = new Order1();
        m = new Medicine();
    }
    
    public String addOrderItem(){
        uc.addOrderItem(String.valueOf(oid), String.valueOf(mid), String.valueOf(quantity), String.valueOf(price), String.valueOf(total_amt));
        return "orderItem.xhtml";
    }
    
    public String updateOrderItem(){
        order_item_id = oi.getOrderItemId();
        o = oi.getOid();
        m = oi.getMid();
        quantity = oi.getQuantity();
        price = oi.getPrice();
        total_amt = oi.getTotalAmt();
        
        uc.updateOrderItem(String.valueOf(order_item_id), String.valueOf(oid), String.valueOf(mid), String.valueOf(quantity), String.valueOf(price), String.valueOf(total_amt));
        oi = new OrderItem();
        return "orderItem.xhtml";
    }
    
    public String deleteOrderItem(){
        uc.deleteOrderItem(String.valueOf(order_item_id));
        return "orderItem.xhtml";
    }
    
    public Collection<OrderItem> getAllOrderItem(){
        rs = uc.getAllOrderItem(Response.class);
        orderitem = rs.readEntity(gorderitem);
        return orderitem;
    }
    
    public String redirectToUpdate(){
        return "orderItemUpdate.xhtml";
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

    public OrderItem getOi() {
        return oi;
    }

    public void setOi(OrderItem oi) {
        this.oi = oi;
    }

    public Order1 getO() {
        return o;
    }

    public void setO(Order1 o) {
        this.o = o;
    }

    public Medicine getM() {
        return m;
    }

    public void setM(Medicine m) {
        this.m = m;
    }

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public BigDecimal getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(BigDecimal total_amt) {
        this.total_amt = total_amt;
    }

    public Collection<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Collection<OrderItem> orderitem) {
        this.orderitem = orderitem;
    }

    public GenericType<Collection<OrderItem>> getGorderitem() {
        return gorderitem;
    }

    public void setGorderitem(GenericType<Collection<OrderItem>> gorderitem) {
        this.gorderitem = gorderitem;
    }

    public Collection<Order1> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order1> order) {
        this.order = order;
    }

    public GenericType<Collection<Order1>> getGorder() {
        return gorder;
    }

    public void setGorder(GenericType<Collection<Order1>> gorder) {
        this.gorder = gorder;
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
