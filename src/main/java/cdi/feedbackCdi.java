/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.adminClient;
import client.userClient;
import entity.Feedback;
import entity.UserMst;
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
@Named(value = "feedbackCdi")
@SessionScoped
public class feedbackCdi implements Serializable {
    
    userClient uc;
    adminClient ac;
    Response rs;
    Feedback fb;
    UserMst u;
    
    Integer fid;
    Integer uid;
    Integer rating;
    String comments;
    Date feedback_date;
    Collection<Feedback> feedback;
    GenericType<Collection<Feedback>> gfeedback;
    Collection<UserMst> user;
    GenericType<Collection<UserMst>> guser;

    /**
     * Creates a new instance of feedbackCdi
     */
    public feedbackCdi() {
        uc = new userClient();
        ac = new adminClient();
        feedback = new ArrayList<>();
        gfeedback = new GenericType<Collection<Feedback>>(){};
        user = new ArrayList<>();
        guser = new GenericType<Collection<UserMst>>(){};
        fb = new Feedback();
        u = new UserMst();
    }
    
    public String addFeedback(){
        uc.addFeedback(String.valueOf(uid), String.valueOf(rating), comments);
        return "feedback.xhtml";
    }
    
    public String updateFeedback(){
        fid = fb.getFid();
        u = fb.getUid();
        rating = fb.getRating();
        comments = fb.getComments();
        feedback_date = fb.getFeedbackDate();
        
        uc.updateFeedback(String.valueOf(fid), String.valueOf(uid), String.valueOf(rating), comments);
        fb = new Feedback();
        return "feedback.xhtml";
    }
    
    public String deleteFeedback(){
        uc.deleteFeedback(String.valueOf(fid));
        return "feedback.xhtml";
    }
    
    public Collection<Feedback> getAllFeedback(){
        rs = ac.getAllFeedback(Response.class);
        feedback = rs.readEntity(gfeedback);
        return feedback;
    }
    
    public String redirectToUpdate(){
        return "feedbackUpdate.xhtml";
    }

    public userClient getUc() {
        return uc;
    }

    public void setUc(userClient uc) {
        this.uc = uc;
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

    public Feedback getFb() {
        return fb;
    }

    public void setFb(Feedback fb) {
        this.fb = fb;
    }

    public UserMst getU() {
        return u;
    }

    public void setU(UserMst u) {
        this.u = u;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Date feedback_date) {
        this.feedback_date = feedback_date;
    }

    public Collection<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(Collection<Feedback> feedback) {
        this.feedback = feedback;
    }

    public GenericType<Collection<Feedback>> getGfeedback() {
        return gfeedback;
    }

    public void setGfeedback(GenericType<Collection<Feedback>> gfeedback) {
        this.gfeedback = gfeedback;
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
