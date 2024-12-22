/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Feedback;
import entity.Form;
import entity.Medicine;
import entity.Order1;
import entity.OrderItem;
import entity.Role;
import entity.UserMst;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abhaya
 */
@Stateless
public class user implements userLocal {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
//    User master table
    @Override
    public void addUserMst(String uname, String email, String password, String address, Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        UserMst um = new UserMst();
        um.setUname(uname);
        um.setEmail(email);
        um.setPassword(password);
        um.setAddress(address);
        um.setRid(r);
        
        r.getUserMstCollection().add(um);
        
        em.merge(r);
        em.persist(um);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateUserMst(Integer uid, String uname, String email, String password, String address, Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        um.setUname(uname);
        um.setEmail(email);
        um.setPassword(password);
        um.setAddress(address);
        um.setRid(r);
        em.merge(um);
        em.merge(r);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUserMst(Integer uid) {
//        Role r = (Role) em.find(Role.class, rid);
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        
        em.remove(um);
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Collection<UserMst> getAllUsers() {
        return em.createNamedQuery("UserMst.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    Cart table
    @Override
    public void addCart(Integer uid, String status) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = new Cart();
        c.setUid(um);
        c.setCreatedAt(new Date());
        c.setUpdatedAt(new Date());
        c.setStatus(status);
        
        um.getCartCollection().add(c);
        em.merge(um);
        em.persist(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCart(Integer cartid, Integer uid, String status) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = (Cart) em.find(Cart.class, cartid);
        c.setCartid(cartid);
        c.setUid(um);
        c.setCreatedAt(new Date());
        c.setUpdatedAt(new Date());
        c.setStatus(status);
        em.merge(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCart(Integer cartid) {
//        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = (Cart) em.find(Cart.class, cartid);
        em.remove(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   @Override
    public List<Cart> getAllCart() {
        return em.createNamedQuery("Cart.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    Form table

    @Override
    public void addForm(Integer uid, String fname, BigInteger mno, String gender, String dob, Integer height, Integer weight, String address) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = new Form();
        f.setUid(um);
        f.setFname(fname);
        f.setMno(mno);
        f.setGender(gender);
        f.setDob(dob);
        f.setHeight(height);
        f.setWeight(weight);
        f.setAddress(address);
        
        um.getFormCollection().add(f);
        
        em.merge(um);
        em.persist(f);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateForm(Integer form_id, Integer uid, String fname, BigInteger mno, String gender, String dob, Integer height, Integer weight, String address) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = (Form) em.find(Form.class, form_id);
        f.setFormId(form_id);
        f.setUid(um);
        f.setFname(fname);
        f.setMno(mno);
        f.setGender(gender);
        f.setDob(dob);
        f.setHeight(height);
        f.setWeight(weight);
        f.setAddress(address);
        em.merge(f);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteForm(Integer form_id) {
//        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = (Form) em.find(Form.class, form_id);
        
        em.remove(f);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  
    
    
//    feedback table

    @Override
    public void addFeddback(Integer uid, Integer rating, String comments) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = new Feedback();
        fd.setUid(um);
        fd.setRating(rating);
        fd.setComments(comments);
        fd.setFeedbackDate(new Date());
        
        um.getFeedbackCollection().add(fd);
        
        em.merge(um);
        em.persist(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateFeedback(Integer fid, Integer uid, Integer rating, String comments) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = (Feedback) em.find(Feedback.class, fid);
        fd.setFid(fid);
        fd.setUid(um);
        fd.setRating(rating);
        fd.setComments(comments);
        fd.setFeedbackDate(new Date());
        em.merge(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteFeedback(Integer fid) {
//        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = (Feedback) em.find(Feedback.class, fid);
        
        em.remove(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


//    order 
    @Override
    public void addOrder(Integer uid, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = new Order1();
        or.setUid(um);
        or.setOrderDate(new Date());
        or.setStatus(status);
        or.setTotalAmt(total_amt);
        or.setShippingAdd(shipping_add);;
        or.setPaymentStatus(payment_status);
        or.setPaymentMethod(payment_method);
        
        um.getOrder1Collection().add(or);
        
        em.merge(um);
        em.persist(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateOrder(Integer oid, Integer uid, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = (Order1) em.find(Order1.class, oid);
        or.setOid(oid);
        or.setUid(um);
        or.setOrderDate(new Date());
        or.setStatus(status);
        or.setTotalAmt(total_amt);
        or.setShippingAdd(shipping_add);;
        or.setPaymentStatus(payment_status);
        or.setPaymentMethod(payment_method);
        em.merge(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteOrder(Integer oid) {
//        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = (Order1) em.find(Order1.class, oid);
        
        em.remove(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order1> getAllOrders() {
        return em.createNamedQuery("Order1.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
//    order item

    @Override
    public void addOrderItem(Integer oid, Integer mid, Integer quantity, BigDecimal price, BigDecimal total_amt) {
        Order1 or = (Order1) em.find(Order1.class, oid);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        OrderItem ot = new OrderItem();
        ot.setOid(or);
        ot.setMid(m);
        ot.setQuantity(quantity);
        ot.setPrice(price);
        ot.setTotalAmt(total_amt);
        
        or.getOrderItemCollection().add(ot);
        m.getOrderItemCollection().add(ot);
        
        em.merge(or);
        em.merge(m);
        em.persist(ot);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateOrderItem(Integer order_item_id, Integer oid, Integer mid, Integer quantity, BigDecimal price, BigDecimal total_amt) {
        Order1 or = (Order1) em.find(Order1.class, oid);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        OrderItem ot = (OrderItem) em.find(OrderItem.class, order_item_id);
        ot.setOrderItemId(order_item_id);
        ot.setOid(or);
        ot.setMid(m);
        ot.setQuantity(quantity);
        ot.setPrice(price);
        ot.setTotalAmt(total_amt);
        em.merge(ot);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteOrderItem(Integer order_item_id) {
//        Order1 or = (Order1) em.find(Order1.class, oid);
//        Medicine m = (Medicine) em.find(Medicine.class, mid);
        OrderItem ot = (OrderItem) em.find(OrderItem.class, order_item_id);
        
        em.remove(ot);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return em.createNamedQuery("OrderItem.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
