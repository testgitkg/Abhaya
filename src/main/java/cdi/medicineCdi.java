/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import ejb.adminLocal;
import entity.Brand;
import entity.Category;
import entity.Medicine;
import jakarta.ejb.EJB;
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
@Named(value = "medicineCdi")
@SessionScoped
public class medicineCdi implements Serializable {
    
    adminClient ac;
    @EJB adminLocal al;
    Response rs;
    Medicine m;
    Brand b;
    Category c;
    
    Integer mid;
    String mname;
    String img;
    String description;
    Integer price;
    String quantity;
    String availability;
    Integer bid;
    Integer cat_id;
    Collection<Medicine> medicine;
    GenericType<Collection<Medicine>> gmedicine;
    Collection<Brand> brand;
    GenericType<Collection<Brand>> gbrand;
    Collection<Category> category;
    GenericType<Collection<Category>> gcategory;
    

    /**
     * Creates a new instance of medicineCdi
     */
    public medicineCdi() {
        ac = new adminClient();
        medicine = new ArrayList<>();
        gmedicine = new GenericType<Collection<Medicine>>(){};
        brand = new ArrayList<>();
        gbrand = new GenericType<Collection<Brand>>(){};
        category = new ArrayList<>();
        gcategory = new GenericType<Collection<Category>>(){};
        m = new Medicine();
        b = new Brand();
        c = new Category();
    }
    
    public String addMedicine(){
        ac.addMedicine(mname, img, description, String.valueOf(price) ,quantity, availability, String.valueOf(bid), String.valueOf(cat_id));;
        return "medicine.xhtml";
    }
    
    public String updateMedicine(){
        mid = m.getMid();
        mname = m.getMname();
        img = m.getImg();
        description = m.getDescription();
        price = m.getPrice();
        quantity = m.getQuantity();
        availability = m.getAvailability();
        b = m.getBid();
        c = m.getCatId();
        
        ac.updateMedicine(String.valueOf(mid), mname, img, description, String.valueOf(price), quantity, availability, String.valueOf(bid), String.valueOf(cat_id));
        m = new Medicine();
        return "medicine.xhtml";
    }
    
    public String deleteMedicine(){
        ac.deleteMedicine(String.valueOf(mid));
        return "medicine.xhtml";
    }
    
    public Collection<Medicine> getAllMedicine(){
        rs = ac.getAllMedicines(Response.class);
        medicine = rs.readEntity(gmedicine);
        return medicine;
    }
    
    public String redirectToUpdate(){
        return "medicineUpdate.xhtml";
    }
    
//    public Collection<Medicine> getMedicinesByCategory(String cname) {
//    // Implement logic to fetch medicines by category from database or service
//    return al.getMedicineByCatId(cname);
//}


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

    public Medicine getM() {
        return m;
    }

    public void setM(Medicine m) {
        this.m = m;
    }

    public Brand getB() {
        return b;
    }

    public void setB(Brand b) {
        this.b = b;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
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

    public Collection<Brand> getBrand() {
        return brand;
    }

    public void setBrand(Collection<Brand> brand) {
        this.brand = brand;
    }

    public GenericType<Collection<Brand>> getGbrand() {
        return gbrand;
    }

    public void setGbrand(GenericType<Collection<Brand>> gbrand) {
        this.gbrand = gbrand;
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
