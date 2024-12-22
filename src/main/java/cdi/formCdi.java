/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import client.userClient;
import entity.Form;
import entity.UserMst;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "formCdi")
@SessionScoped
public class formCdi implements Serializable {
    
    userClient uc;
    adminClient ac;
    Response rs;
    Form f;
    UserMst u;
    
    Integer form_id;
    Integer uid;
    String fname;
    BigInteger mno;
    String gender;
    String dob;
    Integer height;
    Integer weight;
    String address;
    Collection<Form> form;
    GenericType<Collection<Form>> gform;
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;
    

    /**
     * Creates a new instance of formCdi
     */
    public formCdi() {
        uc = new userClient();
        ac = new adminClient();
        form = new ArrayList<>();
        gform = new GenericType<Collection<Form>>(){};
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        f = new Form();
        u = new UserMst();
    }
    
    public String addForm(){
        uc.addForm(String.valueOf(uid), fname, String.valueOf(mno), gender, dob, String.valueOf(height), String.valueOf(weight), address);
        return "form.xhtml";
    }
    
    public String updateForm(){
        form_id = f.getFormId();
        u = f.getUid();
        fname = f.getFname();
        mno = f.getMno();
        gender = f.getGender();
        dob = f.getDob();
        height = f.getHeight();
        weight = f.getWeight();
        address = f.getAddress();
        
        uc.updateForm(String.valueOf(form_id), String.valueOf(uid), fname, String.valueOf(mno), gender, dob, String.valueOf(height), String.valueOf(weight), address);
        f = new Form();
        return "form.xhtml";
    }
    
    public String deleteForm(){
        uc.deleteForm(String.valueOf(form_id));
        return "form.xhtml";
    }

    public Collection<Form> getAllForm(){
        rs = ac.getAllForm(Response.class);
        form = rs.readEntity(gform);
        return form;
    }
    
    public String redirectToUpdate(){
        return "formUpdate.xhtml";
    }
    
    public userClient getUc() {
        return uc;
    }

    public void setUc(userClient uc) {
        this.uc = uc;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
    }

    public Integer getForm_id() {
        return form_id;
    }

    public void setForm_id(Integer form_id) {
        this.form_id = form_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public BigInteger getMno() {
        return mno;
    }

    public void setMno(BigInteger mno) {
        this.mno = mno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Form> getForm() {
        return form;
    }

    public void setForm(Collection<Form> form) {
        this.form = form;
    }

    public GenericType<Collection<Form>> getGform() {
        return gform;
    }

    public void setGform(GenericType<Collection<Form>> gform) {
        this.gform = gform;
    }

    public Collection<UserMst> getUser() {
        return user;
    }

    public void setUser(Collection<UserMst> user) {
        this.user = user;
    }

    public GenericType<Collection<UserMst>> getGuser() {
        return guser;
    }

    public void setGuser(GenericType<Collection<UserMst>> guser) {
        this.guser = guser;
    }
    
    
    
}
