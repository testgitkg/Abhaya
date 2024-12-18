/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import entity.Brand;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "brandCdi")
@RequestScoped
public class brandCdi {
    
    @EJB adminLocal al;
    
    Brand b = new Brand();
    Collection<Brand> brand;
    GenericType<Collection<Brand>> gbrand;
    String bname;
    String bimg;
    String manufacturer;
    String country_origin;
    String site_url;

    /**
     * Creates a new instance of brandCdi
     */
    public brandCdi() {
    }

    public Brand getB() {
        return b;
    }

    public void setB(Brand b) {
        this.b = b;
    }

    public Collection<Brand> getBrand() {
        return brand;
    }

    public void setBrand(Collection<Brand> brand) {
        this.brand = brand;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry_origin() {
        return country_origin;
    }

    public void setCountry_origin(String country_origin) {
        this.country_origin = country_origin;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }
    
    
    
    
    public String addBrand(){
        al.addBrand(bname, bimg, manufacturer, country_origin, site_url);
        return "blog.xhtml";
    }
    
    public String updateBrand(){
        
        return "blog.xhtml";
    }
    
    public void deleteBrand(Integer bid){
        al.deleteBrand(bid);
    }
    
    public Collection<Brand> getAllBrands(){
        return al.getAllBrands();
    }
    
    
    
}
