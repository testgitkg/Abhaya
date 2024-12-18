/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.InventoryManage;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "inventoryCdi")
@RequestScoped
public class inventoryCdi {
    
    @EJB adminLocal al;
    
    InventoryManage im = new InventoryManage();
    Collection<InventoryManage> inventory;

    /**
     * Creates a new instance of inventoryCdi
     */
    public inventoryCdi() {
    }

    public InventoryManage getIm() {
        return im;
    }

    public void setIm(InventoryManage im) {
        this.im = im;
    }

    public Collection<InventoryManage> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<InventoryManage> inventory) {
        this.inventory = inventory;
    }
    
    
    
}
