/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Admin;
import entity.Blog;
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

        
    
}
