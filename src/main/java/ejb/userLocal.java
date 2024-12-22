/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Feedback;
import entity.Form;
import entity.Order1;
import entity.OrderItem;
import entity.UserMst;
import jakarta.ejb.Local;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author abhaya
 */
@Local
public interface userLocal {
    //user master
    void addUserMst(String uname, String email, String password, String address, Integer rid);
    void updateUserMst(Integer uid, String uname, String email, String password, String address, Integer rid);
    void deleteUserMst(Integer uid);
    Collection<UserMst> getAllUsers();
    
    //cart table
    void addCart(Integer uid, String status);
    void updateCart(Integer cartid, Integer uid, String status);
    void deleteCart(Integer cartid);
    Collection<Cart> getAllCart();
    
//    form
    void addForm(Integer uid, String fname, BigInteger mno, String gender, String dob, Integer height, Integer weight, String address);
    void updateForm(Integer form_id, Integer uid, String fname, BigInteger mno, String gender, String dob, Integer height, Integer weight, String address);
    void deleteForm(Integer form_id);    
    
//    feedback
    void addFeddback(Integer uid, Integer rating, String comments);
    void updateFeedback(Integer fid, Integer uid, Integer rating, String comments);
    void deleteFeedback(Integer fid);    
    
//    Order1
    void addOrder(Integer uid, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method);
    void updateOrder(Integer oid, Integer uid, String status, BigDecimal total_amt, String shipping_add, String payment_status, String payment_method);
    void deleteOrder(Integer oid);
    Collection<Order1> getAllOrders();
    
//    order item
    void addOrderItem(Integer oid, Integer mid, Integer quantity, BigDecimal price, BigDecimal total_amt);
    void updateOrderItem(Integer order_item_id, Integer oid, Integer mid, Integer quantity, BigDecimal price, BigDecimal total_amt);
    void deleteOrderItem(Integer order_item_id);
    Collection<OrderItem> getAllOrderItems();
}
