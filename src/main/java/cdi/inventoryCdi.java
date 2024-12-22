/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Admin;
import entity.InventoryManage;
import entity.Medicine;
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
@Named(value = "inventoryCdi")
@SessionScoped
public class inventoryCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    InventoryManage im;
    Medicine m;
    Admin a;
    
    Integer inventory_id;
    Integer mid;
    Integer quantity;
    String action;
    Date action_date;
    Integer managed_by;
    String notes;
    Collection<InventoryManage> inventory;
    GenericType<Collection<InventoryManage>> ginventory;
    Collection<Medicine> medicine;
    GenericType<Collection<Medicine>> gmedicine;
    Collection<Admin> admin;
    GenericType<Collection<Admin>> gadmin;

    /**
     * Creates a new instance of inventoryCdi
     */
    public inventoryCdi() {
        ac = new adminClient();
        inventory = new ArrayList<>();
        ginventory = new GenericType<Collection<InventoryManage>>(){};
        medicine = new ArrayList<>();
        gmedicine = new GenericType<Collection<Medicine>>(){};
        admin = new ArrayList<>();
        gadmin = new GenericType<Collection<Admin>>(){};
        im = new InventoryManage();
        m = new Medicine();
        a = new Admin();
    }
    
    public String addInventory(){
        ac.addInventory(String.valueOf(mid), String.valueOf(quantity), action, String.valueOf(managed_by), notes);
        return "inventory.xhtml";
    }
    
    public String updateInventory(){
        inventory_id = im.getInventoryId();
        m = im.getMid();
        quantity = im.getQuantity();
        action = im.getAction();
        action_date = im.getActionDate();
        a = im.getManagedBy();
        notes = im.getNotes();
        
        ac.updateInventory(String.valueOf(inventory_id), String.valueOf(mid), String.valueOf(quantity), action, String.valueOf(managed_by), notes);
        im = new InventoryManage();
        return "inventory.xhtml";
    }
    
    public String deleteInventory(){
        ac.deleteInventory(String.valueOf(inventory_id));
        return "inventory.xhtml";
    }
    
    public Collection<InventoryManage> getAllInventories(){
        rs = ac.getAllInventories(Response.class);
        inventory = rs.readEntity(ginventory);
        return inventory;
    }
    
    public String redirectToUpdate(){
        return "inventoryUpdate.xhtml";
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

    public InventoryManage getIm() {
        return im;
    }

    public void setIm(InventoryManage im) {
        this.im = im;
    }

    public Medicine getM() {
        return m;
    }

    public void setM(Medicine m) {
        this.m = m;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getAction_date() {
        return action_date;
    }

    public void setAction_date(Date action_date) {
        this.action_date = action_date;
    }

    public Integer getManaged_by() {
        return managed_by;
    }

    public void setManaged_by(Integer managed_by) {
        this.managed_by = managed_by;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Collection<InventoryManage> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<InventoryManage> inventory) {
        this.inventory = inventory;
    }

    public GenericType<Collection<InventoryManage>> getGinventory() {
        return ginventory;
    }

    public void setGinventory(GenericType<Collection<InventoryManage>> ginventory) {
        this.ginventory = ginventory;
    }

    public Collection<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(Collection<Medicine> medicine) {
        this.medicine = medicine;
    }

    public GenericType<Collection<Medicine>> getGmedicine() {
        return gmedicine;
    }

    public void setGmedicine(GenericType<Collection<Medicine>> gmedicine) {
        this.gmedicine = gmedicine;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
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
