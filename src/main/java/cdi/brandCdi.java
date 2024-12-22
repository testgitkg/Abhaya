/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import entity.Brand;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
//import jakarta.servlet.http.Part;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
import java.io.Serializable;
//import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Random;

/**
 *
 * @author 1
 */
@Named(value = "brandCdi")
@SessionScoped
public class brandCdi implements Serializable {
    
    adminClient ac;
    Response rs;
    Brand b;
    
    Integer bid;
    String bname;
    String bimg;
    String manufacturer;
    String country_origin;
    String site_url;
//    private Part photofile;
    Collection<Brand> brand;
    GenericType<Collection<Brand>> gbrand;
    

    /**
     * Creates a new instance of brandCdi
     */
    public brandCdi() {
        ac = new adminClient();
        brand = new ArrayList<>();
        gbrand = new GenericType<Collection<Brand>>(){};
        b = new Brand();
    }
    
    
    public String addBrand(){
        try{
//            if(photofile != null){
//                InputStream input = photofile.getInputStream();
//                String path = "E:\\Java EE\\abhaya\\src\\main\\webapp\\assets\\brand";
//                Random random = new Random();
//                StringBuilder sb = new StringBuilder();
//                
//                // Generate random file name
//                sb.append(random.nextInt(9) + 1);
//                for (int i = 0; i < 11; i++) {
//                    sb.append(random.nextInt(10));
//                }
//                String temp = sb.toString();
//                
//                // Final image name
//                bimg = "IMG_" + temp + photofile.getSubmittedFileName();
//                Files.copy(input, new File(path, bimg).toPath());
//            } else {
//                bimg = ""; // Default to an empty string if no file is uploaded
//            }                    
        
            ac.addBrand(bname, bimg, manufacturer, country_origin, site_url);
            return "brand.xhtml";
        
//        } catch (IOException e) {
//            e.printStackTrace();            
//            return "failure";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
    
    public String updateBrand(){
        bname = b.getBname();
        bimg = b.getBimg();
        manufacturer = b.getManufacturer();
        country_origin = b.getCountryOrigin();
        site_url = b.getSiteUrl();
        
        ac.updateBrand(String.valueOf(bid), bname, bimg, manufacturer, country_origin, site_url);
        b = new Brand();
        return "brand.xhtml";
    }
    
    public String deleteBrand(){
        ac.deleteBrand(String.valueOf(bid));
        return "brand.xhtml";
    }

    public Collection<Brand> getBrands(){
        rs = ac.getAllBrands(Response.class);
        brand = rs.readEntity(gbrand);
        return brand;
    }
    
    public String redirectToUpdate(){
        return "brandUpdate.xhtml";
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

    public Brand getB() {
        return b;
    }

    public void setB(Brand b) {
        this.b = b;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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
    
    
}
