/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Admin;
import entity.Blog;
import entity.Role;
import jakarta.ejb.Local;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Local
public interface adminLocal {
    //roles
    void addRole(String role_name);
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
}
