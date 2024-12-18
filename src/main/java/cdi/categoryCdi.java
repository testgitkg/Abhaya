/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "categoryCdi")
@RequestScoped
public class categoryCdi {
    
    @EJB adminLocal al;
    
    Category c = new Category();
    Collection<Category> cat;

    /**
     * Creates a new instance of categoryCdi
     */
    public categoryCdi() {
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public Collection<Category> getCat() {
        return cat;
    }

    public void setCat(Collection<Category> cat) {
        this.cat = cat;
    }
    
    
    
}
