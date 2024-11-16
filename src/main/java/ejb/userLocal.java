/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Feedback;
import entity.Form;
import entity.Order1;
import entity.UserMst;
import jakarta.ejb.Local;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Local
public interface userLocal {
    //user master
    void addUserMst(String uname, String email, String password, String address, Integer rid);
    void updateUserMst(Integer uid, String uname, String email, String password, String address, Integer rid);
    void deleteUserMst(Integer uid, Integer rid);
    Collection<UserMst> getAllUsers();
    
    //cart table
    void addCart(Integer uid, Timestamp created_at, Timestamp updated_at, String status);
    void updateCart(Integer cartid, Integer uid, Timestamp created_at, Timestamp updated_at, String status);
    void deleteCart(Integer cartid, Integer uid);
    Collection<Cart> getAllCart();
    
//    form
    void addForm(Integer uid, String fname, BigInteger mno, String gender, Date dob, Integer height, Integer weight, String address);
    void updateForm(Integer form_id, Integer uid, String fname, BigInteger mno, String gender, Date dob, Integer height, Integer weight, String address);
    void deleteForm(Integer form_id, Integer uid);
    Collection<Form> getAllForm();
    
//    feedback
    void addFeddback(Integer uid, Integer rating, String comments, Date feedback_date);
    void updateFeedback(Integer fid, Integer uid, Integer rating, String comments, Date feedback_date);
    void deleteFeedback(Integer fid, Integer uid);
    Collection<Feedback> getAllFeedback();
    
//    Order1
    void addOrder(Integer uid, Date order_date, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method);
    void updateOrder(Integer oid, Integer uid, Date order_date, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method);
    void deleteOrder(Integer oid, Integer uid);
    Collection<Order1> getAllOrders();
}
