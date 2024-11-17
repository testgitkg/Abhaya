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
import entity.InventoryManage;
import entity.Medicine;
import entity.OrderManage;
import entity.Role;
import jakarta.ejb.Local;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Local
public interface adminLocal {
    //roles
    void addRole(String role_name);
    void updateRole(Integer rid, String role_name);
    void deleteRole(Integer rid);
    Collection<Role> getAllRoles();
    
    //admin detail
    void addAdmin(String aname, String email, String password, Integer rid);
    void updateAdmin(Integer aid, String aname, String email, String password, Integer rid);
    void deleteAdmin(Integer aid, Integer rid);
    Collection<Admin> getAllAdmin();
    
    //blog detail
    void addBlog(Integer aid, String title, String content, String status, Timestamp created_at, Timestamp updated_at, String tags);
    void updateBlog(Integer blog_id, Integer aid, String title, String content, String status, Timestamp created_at, Timestamp updated_at, String tags);
    void deleteBlog(Integer blog_id, Integer aid);
    Collection<Blog> getAllBlog();
    
    //brand
    void addBrand(String bname, byte[] img, String manufacturer, String country_origin, String site_url);
    void updateBrand(Integer bid, String bname, byte[] img, String manufacturer, String country_origin, String site_url);
    void deleteBrand(Integer bid);
    Collection<Brand> getAllBrands();
    
    //category
    void addCategory(String cname, String description);
    void updateCategory(Integer cat_id, String cname, String description);
    void deleteCategory(Integer cat_id);
    Collection<Category> getAllCategories();
    
    //medicine
    void addMedicine(String mname, byte[] img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id);
    void updateMedicine(Integer mid, String mname, byte[] img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id);
    void deleteMedicine(Integer mid, Integer bid, Integer cat_id);
    Collection<Medicine> getAllMedicines();
    
    //cart _item
    void addCartItem(Integer cartid, Integer mid, Integer quantity, BigDecimal price);
    void updateCartItem(Integer cart_item_id, Integer cartid, Integer mid, Integer quantity, BigDecimal price);
    void deleteCartItem(Integer cart_item_id, Integer cartid, Integer mid);
    Collection<CartItem> getAllCartItems();
    
    // order manage
    void addOrderManage(Integer oid, String status, Timestamp timestamp);
    void updateOrderManage(Integer manage_id, Integer oid, String status, Timestamp timestamp);
    void deleteOrderManage(Integer manage_id, Integer oid);
    Collection<OrderManage> getAllOrderManages();
    
//    inventory manage
    void addInventory(Integer mid, Integer quantity, String action, Timestamp action_date, Integer managed_by, String notes);
    void updateInventory(Integer inventory_id, Integer mid, Integer quantity, String action, Timestamp action_date, Integer managed_by, String notes);
    void deleteInventory(Integer inventory_id, Integer mid);
    Collection<InventoryManage> getAllInventories();
}
