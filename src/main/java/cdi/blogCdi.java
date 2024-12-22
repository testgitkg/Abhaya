/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Admin;
import entity.Blog;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Named(value = "blogCdi")
@SessionScoped
public class blogCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    Blog b;
    Admin a;
    
    Integer blog_id;
    Integer aid;
    String title;
    String content;
    String status;
//    Date created_at;
//    Date updated_at;
    String tags;
    Collection<Blog> blog;
    GenericType<Collection<Blog>> gblog;
    
    Collection<Admin> admin;
    GenericType<Collection<Admin>> gadmin;

    /**
     * Creates a new instance of blogCdi
     */
    public blogCdi() {
        ac = new adminClient();
        blog = new ArrayList<>();
        gblog = new GenericType<Collection<Blog>>(){};
        admin = new ArrayList<>();
        gadmin = new GenericType<Collection<Admin>>(){};
        b = new Blog();
        a = new Admin();        
    }

    public String addBlog(){
        ac.addBlog(String.valueOf(aid), title, content, status, tags);
        return "blog.xhtml";
    }
    
    public String updateBlog(){
        blog_id = b.getBlogId();
        a = b.getAid();
        title = b.getTitle();
        content = b.getContent();
        status = b.getStatus();
//        created_at = b.getCreatedAt();
//        updated_at = b.getUpdatedAt();
        tags = b.getTags();
        
        ac.updateBlog(String.valueOf(blog_id), String.valueOf(aid), title, content, status, tags);
        b = new Blog();
        return "blog.xhtml";
    }
    
    public String deleteBlog(){
        ac.deleteBlog(String.valueOf(blog_id));
        return "blog.xhtml";
    }
    
    public Collection<Blog> getAllBlog(){
        rs = ac.getAllBlog(Response.class);
        blog = rs.readEntity(gblog);
        return blog;
    }
    
    public String redirectToUpdate(){
        return "blogUpdate.xhtml";
    }
    
    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Blog getB() {
        return b;
    }

    public void setB(Blog b) {
        this.b = b;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
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

    public Collection<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Collection<Blog> blog) {
        this.blog = blog;
    }

    public GenericType<Collection<Blog>> getGblog() {
        return gblog;
    }

    public void setGblog(GenericType<Collection<Blog>> gblog) {
        this.gblog = gblog;
    }

    public Collection<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(Collection<Admin> admin) {
        this.admin = admin;
    }

    public GenericType<Collection<Admin>> getGadmin() {
        return gadmin;
    }

    public void setGadmin(GenericType<Collection<Admin>> gadmin) {
        this.gadmin = gadmin;
    }
      
    
}
