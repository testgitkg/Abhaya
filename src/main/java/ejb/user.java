/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Feedback;
import entity.Form;
import entity.Order1;
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

/**
 *
 * @author 1
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
    public void deleteUserMst(Integer uid,Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
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
    public void addCart(Integer uid, Timestamp created_at, Timestamp updated_at, String status) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = new Cart();
        c.setUid(um);
        c.setCreatedAt(created_at);
        c.setUpdatedAt(updated_at);
        c.setStatus(status);
        em.persist(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCart(Integer cartid, Integer uid, Timestamp created_at, Timestamp updated_at, String status) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = (Cart) em.find(Cart.class, cartid);
        c.setCartid(cartid);
        c.setUid(um);
        c.setCreatedAt(created_at);
        c.setUpdatedAt(updated_at);
        c.setStatus(status);
        em.merge(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCart(Integer cartid, Integer uid) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Cart c = (Cart) em.find(Cart.class, cartid);
        em.remove(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   @Override
    public Collection<Cart> getAllCart() {
        return em.createNamedQuery("Cart.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    Form table

    @Override
    public void addForm(Integer uid, String fname, BigInteger mno, String gender, Date dob, Integer height, Integer weight, String address) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = new Form();
        um.setUid(uid);
        f.setFname(fname);
        f.setMno(mno);
        f.setGender(gender);
        f.setDob(dob);
        f.setHeight(height);
        f.setWeight(weight);
        f.setAddress(address);
        em.persist(f);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateForm(Integer form_id, Integer uid, String fname, BigInteger mno, String gender, Date dob, Integer height, Integer weight, String address) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = (Form) em.find(Form.class, form_id);
        f.setFormId(form_id);
        um.setUid(uid);
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
    public void deleteForm(Integer form_id, Integer uid) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Form f = (Form) em.find(Form.class, form_id);
        em.remove(f);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Collection<Form> getAllForm() {
        return em.createNamedQuery("Form.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
//    feedback table

    @Override
    public void addFeddback(Integer uid, Integer rating, String comments, Date feedback_date) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = new Feedback();
        um.setUid(uid);
        fd.setRating(rating);
        fd.setComments(comments);
        fd.setFeedbackDate(feedback_date);
        em.persist(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateFeedback(Integer fid, Integer uid, Integer rating, String comments, Date feedback_date) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = (Feedback) em.find(Feedback.class, fid);
        fd.setFid(fid);
        um.setUid(uid);
        fd.setRating(rating);
        fd.setComments(comments);
        fd.setFeedbackDate(feedback_date);
        em.merge(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteFeedback(Integer fid, Integer uid) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Feedback fd = (Feedback) em.find(Feedback.class, fid);
        em.remove(fd);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Feedback> getAllFeedback() {
        return em.createNamedQuery("Feedback.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    order 
    @Override
    public void addOrder(Integer uid, Date order_date, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = new Order1();
        um.setUid(uid);
        or.setOrderDate(order_date);
        or.setStatus(status);
        or.setTotalAmt(total_amt);
        or.setShippingAdd(shipping_add);;
        or.setPaymentStatus(payment_status);
        or.setPaymentMethod(payment_method);
        em.persist(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateOrder(Integer oid, Integer uid, Date order_date, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = (Order1) em.find(Order1.class, oid);
        or.setOid(oid);
        um.setUid(uid);
        or.setOrderDate(order_date);
        or.setStatus(status);
        or.setTotalAmt(total_amt);
        or.setShippingAdd(shipping_add);;
        or.setPaymentStatus(payment_status);
        or.setPaymentMethod(payment_method);
        em.merge(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteOrder(Integer oid, Integer uid) {
        UserMst um = (UserMst) em.find(UserMst.class, uid);
        Order1 or = (Order1) em.find(Order1.class, oid);
        em.remove(or);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Order1> getAllOrders() {
        return em.createNamedQuery("Order1.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
