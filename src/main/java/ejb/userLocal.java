/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Form;
import entity.UserMst;
import jakarta.ejb.Local;
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
    Collection<Form> getAllForm();
}
