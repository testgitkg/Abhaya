/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.Category;
import entity.Medicine;
import entity.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        Role role = new Role();
        role.setRoleName(role_name);
        em.persist(role);
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
    
    
    
}
