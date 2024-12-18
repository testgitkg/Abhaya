/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Blog;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "blogCdi")
@RequestScoped
public class blogCdi {
    
    @EJB adminLocal al;
    
    Blog b = new Blog();
    Collection<Blog> blog;
    GenericType<Collection<Blog>> gblog;
    Integer  aid;
    String title;
    String content;
    String status;
    String tags;

    /**
     * Creates a new instance of blogCdi
     */
    public blogCdi() {
    }

    public Blog getB() {
        return b;
    }

    public void setB(Blog b) {
        this.b = b;
    }

    public Collection<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Collection<Blog> blog) {
        this.blog = blog;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    
    
    
    public String addBlog(){
        al.addBlog(aid, title, content, status, tags);
        return "blog.xhtml";
    }
    
    public String updateBlog(){
        
        return "blog.xhtml";
    }
    
    public void deleteBlog(Integer blog_id, Integer aid){
        al.deleteBlog(blog_id, aid);
    }
    
    public Collection<Blog> getAllBlog(){
        return al.getAllBlog();
    }
    
}
