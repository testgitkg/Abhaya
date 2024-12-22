/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Order1;
import entity.OrderManage;
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
@Named(value = "orderManageCdi")
@SessionScoped
public class orderManageCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    OrderManage om;
    Order1 o;
    
    Integer manage_id;
    Integer oid;
    String status;
    Date timestamp;
    Collection<OrderManage> ordermanage;
    GenericType<Collection<OrderManage>> gordermanage;
    Collection<Order1> order;
    GenericType<Collection<Order1>> gorder;

    /**
     * Creates a new instance of orderManageCdi
     */
    public orderManageCdi() {
        ac = new adminClient();
        ordermanage = new ArrayList<>();
        gordermanage = new GenericType<Collection<OrderManage>>(){};
        order = new ArrayList<>();
        gorder = new GenericType<Collection<Order1>>(){};
        om = new OrderManage();
        o = new Order1();
    }
    
    public String addOrderManage(){
        ac.addOrderManage(String.valueOf(oid), status);
        return "orderManage.xhtml";
    }
    
    public String updateOrderManage(){
        manage_id = om.getManageId();
        o = om.getOid();
        status = om.getStatus();
        timestamp = om.getTimestamp();
        
        ac.updateOrderManage(String.valueOf(manage_id),String.valueOf(oid), status);
        return "orderManage.xhtml";
    }
    
    public String deleteOrderManage(){
        ac.deleteOrderManage(String.valueOf(manage_id));
        return "orderManage.xhtml";
    }
    
    public Collection<OrderManage> getAllOrderManage(){
        rs = ac.getAllOrderManages(Response.class);
        ordermanage = rs.readEntity(gordermanage);
        return ordermanage;
    }
    
    public String redirectToUpdate(){
        return "orderManageUpdate.xhtml";
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

    public OrderManage getOm() {
        return om;
    }

    public void setOm(OrderManage om) {
        this.om = om;
    }

    public Order1 getO() {
        return o;
    }

    public void setO(Order1 o) {
        this.o = o;
    }

    public Integer getManage_id() {
        return manage_id;
    }

    public void setManage_id(Integer manage_id) {
        this.manage_id = manage_id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Collection<OrderManage> getOrdermanage() {
        return ordermanage;
    }

    public void setOrdermanage(Collection<OrderManage> ordermanage) {
        this.ordermanage = ordermanage;
    }

    public GenericType<Collection<OrderManage>> getGordermanage() {
        return gordermanage;
    }

    public void setGordermanage(GenericType<Collection<OrderManage>> gordermanage) {
        this.gordermanage = gordermanage;
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
    
    
    
}
