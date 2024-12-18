/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Medicine;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "medicineCdi")
@RequestScoped
public class medicineCdi {
    
    @EJB adminLocal al;
    
    Medicine m = new Medicine();
    Collection<Medicine> medi;

    /**
     * Creates a new instance of medicineCdi
     */
    public medicineCdi() {
    }

    public Medicine getM() {
        return m;
    }

    public void setM(Medicine m) {
        this.m = m;
    }

    public Collection<Medicine> getMedi() {
        return medi;
    }

    public void setMedi(Collection<Medicine> medi) {
        this.medi = medi;
    }
    
    
    
}
