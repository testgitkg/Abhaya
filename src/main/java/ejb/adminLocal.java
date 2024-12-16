/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.CartItem;
import entity.Category;
import entity.Feedback;
import entity.Form;
import entity.InventoryManage;
import entity.Medicine;
import entity.Order1;
import entity.OrderManage;
import entity.Role;
import entity.UserMst;
import jakarta.ejb.Local;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author abhaya
 */
@Local
public interface adminLocal {
    //roles
    void addRole(String role_name);
    void updateRole(Integer rid, String role_name);
    void deleteRole(Integer rid);
    Collection<Role> getAllRoles();
    Collection<Role> getRoleById(Integer rid);
    Collection<Role> getRoleByName(String role_name);
    
    //admin detail
    void addAdmin(String aname, String email, String password, Integer rid);
    void updateAdmin(Integer aid, String aname, String email, String password, Integer rid);
    void deleteAdmin(Integer aid, Integer rid);
    Collection<Admin> getAllAdmin();
    Collection<Admin> getAdminById(Integer aid);
    Collection<Admin> getAdminbyName(String aname);
    
    //blog detail
    void addBlog(Integer aid, String title, String content, String status, String tags);
    void updateBlog(Integer blog_id, Integer aid, String title, String content, String status, String tags);
    void deleteBlog(Integer blog_id, Integer aid);
    Collection<Blog> getAllBlog();
    Collection<Blog> getBlogByid(Integer blog_id);
    Collection<Blog> getBlogByTitle(String title);
    Collection<Blog> getBlogByTag(String tags);
    
    //brand
    void addBrand(String bname, String img, String manufacturer, String country_origin, String site_url);
    void updateBrand(Integer bid, String bname, String img, String manufacturer, String country_origin, String site_url);
    void deleteBrand(Integer bid);
    Collection<Brand> getAllBrands();
    Collection<Brand> getBrandByBname(String bname);
    
    
    //category
    void addCategory(String cname, String description);
    void updateCategory(Integer cat_id, String cname, String description);
    void deleteCategory(Integer cat_id);
    Collection<Category> getAllCategories();
    Collection<Category> getCategoryByCname(String cname);
    
    //medicine
    void addMedicine(String mname, String img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id);
    void updateMedicine(Integer mid, String mname, String img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id);
    void deleteMedicine(Integer mid, Integer bid, Integer cat_id);
    Collection<Medicine> getAllMedicines();
    Collection<Medicine> getMedicineByMname(String mname);
    Collection<Medicine> getMediByAvailability(String availability);
    
    //cart _item
    void addCartItem(Integer cartid, Integer mid, Integer quantity, BigDecimal price);
    void updateCartItem(Integer cart_item_id, Integer cartid, Integer mid, Integer quantity, BigDecimal price);
    void deleteCartItem(Integer cart_item_id, Integer cartid, Integer mid);
    Collection<CartItem> getAllCartItems();
    
    // order manage
    void addOrderManage(Integer oid, String status);
    void updateOrderManage(Integer manage_id, Integer oid, String status);
    void deleteOrderManage(Integer manage_id, Integer oid);
    Collection<OrderManage> getAllOrderManages();
    Collection<OrderManage> getStatus(String status);
    
    // inventory manage
    void addInventory(Integer mid, Integer quantity, String action, Integer managed_by, String notes);
    void updateInventory(Integer inventory_id, Integer mid, Integer quantity, String action, Integer managed_by, String notes);
    void deleteInventory(Integer inventory_id, Integer mid);
    Collection<InventoryManage> getAllInventories();
    Collection<InventoryManage> getInventoryByAction(String action);
    
    // showing user data from user side
    Collection<UserMst> getAllUsers();
    Collection<UserMst> getUserByUname(String uname);
    Collection<UserMst> getUserByEmail(String email);
    
    // form detail of user
    Collection<Form> getAllForm();
    Collection<Form> getFormByFormId(Integer form_id);
    Collection<Form> getFormByFname(String fname);
    
    //feedback of users
    Collection<Feedback> getAllFeedback();
    Collection<Feedback> getFeedbackByFid(Integer fid);
    
    // order by user
    Collection<Order1> getAllOrders();
    Collection<Order1> getOrderByOid(Integer oid);
    Collection<Order1> getOrderByStatus(String status);
}
