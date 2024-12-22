/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import client.userClient;
import entity.Order1;
import entity.UserMst;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Named(value = "orderCdi")
@SessionScoped
public class orderCdi implements Serializable {
    
    userClient uc;
    adminClient ac;
    Response rs;
    Order1 o;
    UserMst u;
    
    Integer oid;
    Integer uid;
    Date order_date;
    String status;
    BigDecimal total_amt;
    String shipping_add;
    String payment_status;
    String payment_method;
    Collection<Order1> order;
    GenericType<Collection<Order1>> gorder;
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;
    

    /**
     * Creates a new instance of orderCdi
     */
    public orderCdi() {
        uc = new userClient();
        ac = new adminClient();
        order = new ArrayList<>();
        gorder = new GenericType<Collection<Order1>>(){};
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        o = new Order1();
        u = new UserMst();
    }

    public String addOrder(){
        uc.addOrder(String.valueOf(uid), status, String.valueOf(total_amt), shipping_add, payment_status, payment_method);
        return "order.xhtml";
    }
    
    public String updateOrder(){
        oid = o.getOid();
        u = o.getUid();
        order_date = o.getOrderDate();
        status = o.getStatus();
        total_amt = o.getTotalAmt();
        shipping_add = o.getShippingAdd();
        payment_status = o.getPaymentStatus();
        payment_method = o.getPaymentMethod();
        
        uc.updateOrder(String.valueOf(oid), String.valueOf(uid), status, String.valueOf(total_amt), shipping_add, payment_status, payment_method);
        o = new Order1();
        return "order.xhtml";
    }
    
    public String deleteOrder(){
        uc.deleteOrder(String.valueOf(oid));
        return "order.xhtml";
    }
    
    public Collection<Order1> getAllOrders(){
        rs = ac.getAllOrders(Response.class);
        order = rs.readEntity(gorder);
        return order;
    }
    
    public String redirectToUpdate(){
        return "orderUpdate.xhtml";
    }
    
    public userClient getUc() {
        return uc;
    }

    public void setUc(userClient uc) {
        this.uc = uc;
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

    public Order1 getO() {
        return o;
    }

    public void setO(Order1 o) {
        this.o = o;
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(BigDecimal total_amt) {
        this.total_amt = total_amt;
    }

    public String getShipping_add() {
        return shipping_add;
    }

    public void setShipping_add(String shipping_add) {
        this.shipping_add = shipping_add;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
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
