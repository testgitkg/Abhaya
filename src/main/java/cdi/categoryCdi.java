/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Category;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "categoryCdi")
@SessionScoped
public class categoryCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    Category c;
    
    Integer cat_id;
    String cname;
    String description;
    Collection<Category> category;
    GenericType<Collection<Category>> gcategory;

    /**
     * Creates a new instance of categoryCdi
     */
    public categoryCdi() {
        ac = new adminClient();
        category = new ArrayList<>();
        gcategory = new GenericType<Collection<Category>>(){};
        c = new Category();
    }
    
    
    public String addCategory(){
        ac.addCategory(cname, description);
        return "category.xhtml";
    }
    
    public String updateCategory(){
        cat_id = c.getCatId();
        cname = c.getCname();
        description = c.getDescription();
        
        ac.updateCategory(String.valueOf(cat_id), cname, description);
        c = new Category();
        return "category.xhtml";
    }
    
    public String deleteCategory(){
        ac.deleteCategory(String.valueOf(cat_id));
        return "category.xhtml";
    }
    
    public Collection<Category> getAllCategory(){
        rs = ac.getAllCategories(Response.class);
        category = rs.readEntity(gcategory);
        return category;
    }
    
    public String redirectToEdit(){
        return "categoryUpdate.xhtml";
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

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Category> getCategory() {
        return category;
    }

    public void setCategory(Collection<Category> category) {
        this.category = category;
    }

    public GenericType<Collection<Category>> getGcategory() {
        return gcategory;
    }

    public void setGcategory(GenericType<Collection<Category>> gcategory) {
        this.gcategory = gcategory;
    }
    
}
