/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.InventoryManage;
import entity.Medicine;
import entity.Order1;
import entity.OrderManage;
import entity.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Stateless
public class admin implements adminLocal {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
//    role
    @Override
    public void addRole(String role_name) {
        Role r = new Role();
        r.setRoleName(role_name);
        em.persist(r);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateRole(Integer rid, String role_name) {
        Role r = (Role) em.find(Role.class, rid);
        r.setRid(rid);
        r.setRoleName(role_name);
        em.merge(r);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteRole(Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        em.remove(r);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
    
    @Override
    public Collection<Role> getAllRoles() {
        return em.createNamedQuery("Role.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    admin
    @Override
    public void addAdmin(String aname, String email, String password, Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        Admin ad = new Admin();
        ad.setAname(aname);
        ad.setEmail(email);
        ad.setPassword(password);
        ad.setRid(r);
        em.persist(ad);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateAdmin(Integer aid, String aname, String email, String password, Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        Admin ad = (Admin) em.find(Admin.class, aid);
        ad.setAid(aid);
        ad.setAname(aname);
        ad.setEmail(email);
        ad.setPassword(password);
        ad.setRid(r);
        em.merge(ad);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAdmin(Integer aid, Integer rid) {
        Role r = (Role) em.find(Role.class, rid);
        Admin ad = (Admin) em.find(Admin.class, aid);
        em.remove(ad);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            
    @Override
    public Collection<Admin> getAllAdmin() {
        return em.createNamedQuery("Admin.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    blog
    @Override
    public void addBlog(Integer aid, String title, String content, String status, Timestamp created_at, Timestamp updated_at, String tags) {
        Admin ad = (Admin) em.find(Admin.class, aid);
        Blog bg = new Blog();
        bg.setAid(ad);
        bg.setTitle(title);
        bg.setContent(content);
        bg.setStatus(status);
        bg.setCreatedAt(created_at);
        bg.setUpdatedAt(updated_at);
        bg.setTags(tags);
        em.persist(bg);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void updateBlog(Integer blog_id, Integer aid, String title, String content, String status, Timestamp created_at, Timestamp updated_at, String tags) {
        Admin ad = (Admin) em.find(Admin.class, aid);
        Blog bg = (Blog) em.find(Blog.class, blog_id);
        bg.setBlogId(blog_id);
        bg.setAid(ad);
        bg.setTitle(title);
        bg.setContent(content);
        bg.setStatus(status);
        bg.setCreatedAt(created_at);
        bg.setUpdatedAt(updated_at);
        bg.setTags(tags);
        em.merge(bg);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteBlog(Integer blog_id, Integer aid) {
        Admin ad = (Admin) em.find(Admin.class, aid);
        Blog bg = (Blog) em.find(Blog.class, blog_id);
        em.remove(bg);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Blog> getAllBlog() {
        return em.createNamedQuery("Blog.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    brand

    @Override
    public void addBrand(String bname, byte[] img, String manufacturer, String country_origin, String site_url) {
        Brand b = new Brand();        
        b.setBname(bname);
        b.setBimg(img);
        b.setManufacturer(manufacturer);
        b.setCountryOrigin(country_origin);
        b.setSiteUrl(site_url);
        em.persist(b);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateBrand(Integer bid, String bname, byte[] img, String manufacturer, String country_origin, String site_url) {
        Brand b = (Brand) em.find(Brand.class, bid);
        b.setBid(bid);
        b.setBname(bname);
        b.setBimg(img);
        b.setManufacturer(manufacturer);
        b.setCountryOrigin(country_origin);
        b.setSiteUrl(site_url);
        em.merge(b);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteBrand(Integer bid) {
        Brand b = (Brand) em.find(Brand.class, bid);
        em.remove(b);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Brand> getAllBrands() {
        return em.createNamedQuery("Brand.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    category

    @Override
    public void addCategory(String cname, String description) {
        Category c = new Category();
        c.setCname(cname);
        c.setDescription(description);
        em.persist(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCategory(Integer cat_id, String cname, String description) {
        Category c = (Category) em.find(Category.class, cat_id);
        c.setCatId(cat_id);
        c.setCname(cname);
        c.setDescription(description);
        em.merge(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCategory(Integer cat_id) {
        Category c = (Category) em.find(Category.class, cat_id);
        em.remove(c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Category> getAllCategories() {
        return em.createNamedQuery("Category.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    medicine

    @Override
    public void addMedicine(String mname, byte[] img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id) {
        Brand b = (Brand) em.find(Brand.class, bid);
        Category c = (Category) em.find(Category.class, cat_id);
        Medicine m = new Medicine();
        m.setMname(mname);
        m.setImg(img);
        m.setDescription(description);
        m.setPrice(price);
        m.setQuantity(quantity);
        m.setAvailability(availability);
        b.setBid(bid);
        c.setCatId(cat_id);
        em.persist(m);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMedicine(Integer mid, String mname, byte[] img, String description, Integer price, String quantity, String availability, Integer bid, Integer cat_id) {
        Brand b = (Brand) em.find(Brand.class, bid);
        Category c = (Category) em.find(Category.class, cat_id);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        m.setMname(mname);
        m.setImg(img);
        m.setDescription(description);
        m.setPrice(price);
        m.setQuantity(quantity);
        m.setAvailability(availability);
        b.setBid(bid);
        c.setCatId(cat_id);
        em.merge(m);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMedicine(Integer mid, Integer bid, Integer cat_id) {
        Brand b = (Brand) em.find(Brand.class, bid);
        Category c = (Category) em.find(Category.class, cat_id);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        em.remove(m);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Medicine> getAllMedicines() {
        return em.createNamedQuery("Medicine.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    Cart item

    @Override
    public void addCartItem(Integer cartid, Integer mid, Integer quantity, BigDecimal price) {
        Cart c = (Cart) em.find(Cart.class, cartid);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        CartItem ct = new CartItem();
        c.setCartid(cartid);
        m.setMid(mid);
        ct.setQuantity(quantity);
        ct.setPrice(price);
        em.persist(ct);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCartItem(Integer cart_item_id, Integer cartid, Integer mid, Integer quantity, BigDecimal price) {
        CartItem ct = (CartItem) em.find(CartItem.class, cart_item_id);
        Cart c = (Cart) em.find(Cart.class, cartid);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        ct.setCartItemId(cart_item_id);
        c.setCartid(cartid);
        m.setMid(mid);
        ct.setQuantity(quantity);
        ct.setPrice(price);
        em.merge(ct);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCartItem(Integer cart_item_id, Integer cartid, Integer mid) {
        CartItem ct = (CartItem) em.find(CartItem.class, cart_item_id);
        Cart c = (Cart) em.find(Cart.class, cartid);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        em.remove(ct);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<CartItem> getAllCartItems() {
        return em.createNamedQuery("CartItem.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    order manage

    @Override
    public void addOrderManage(Integer oid, String status, Timestamp timestamp) {
        Order1 or = (Order1) em.find(Order1.class, oid);
        OrderManage om = new OrderManage();
        or.setOid(oid);
        om.setStatus(status);
        om.setTimestamp(timestamp);
        em.persist(om);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateOrderManage(Integer manage_id, Integer oid, String status, Timestamp timestamp) {
        OrderManage om = (OrderManage) em.find(OrderManage.class, manage_id);
        Order1 or = (Order1) em.find(Order1.class, oid);
        or.setOid(oid);
        om.setStatus(status);
        om.setTimestamp(timestamp);
        em.merge(om);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteOrderManage(Integer manage_id, Integer oid) {
        OrderManage om = (OrderManage) em.find(OrderManage.class, manage_id);
        Order1 or = (Order1) em.find(Order1.class, oid);
        em.remove(om);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<OrderManage> getAllOrderManages() {
        return em.createNamedQuery("OrderManage.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    inventory manage

    @Override
    public void addInventory(Integer mid, Integer quantity, String action, Timestamp action_date, Integer managed_by, String notes) {
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        Admin ad = (Admin) em.find(Admin.class, managed_by);
        InventoryManage im = new InventoryManage();
        m.setMid(mid);
        im.setQuantity(0);
        im.setActionDate(action_date);
        im.setManagedBy(ad);
        im.setNotes(notes);
        em.persist(im);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateInventory(Integer inventory_id, Integer mid, Integer quantity, String action, Timestamp action_date, Integer managed_by, String notes) {
        InventoryManage im = (InventoryManage) em.find(InventoryManage.class, inventory_id);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        Admin ad = (Admin) em.find(Admin.class, managed_by);        
        im.setInventoryId(inventory_id);
        m.setMid(mid);
        im.setQuantity(quantity);
        im.setActionDate(action_date);
        im.setManagedBy(ad);
        im.setNotes(notes);
        em.merge(im);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteInventory(Integer inventory_id, Integer mid) {
        InventoryManage im = (InventoryManage) em.find(InventoryManage.class, inventory_id);
        Medicine m = (Medicine) em.find(Medicine.class, mid);
        em.remove(im);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<InventoryManage> getAllInventories() {
        return em.createNamedQuery("InventoryManage.findAll").getResultList();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
