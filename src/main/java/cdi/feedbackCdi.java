/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import ejb.userLocal;
import entity.Feedback;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "feedbackCdi")
@RequestScoped
public class feedbackCdi {
    
    @EJB adminLocal al;
    @EJB userLocal ul;
    
    Feedback f = new Feedback();
    Collection<Feedback> feedback;

    /**
     * Creates a new instance of feedbackCdi
     */
    public feedbackCdi() {
    }

    public Feedback getF() {
        return f;
    }

    public void setF(Feedback f) {
        this.f = f;
    }

    public Collection<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(Collection<Feedback> feedback) {
        this.feedback = feedback;
    }
    
    
    
    public void deleteFeedback(Integer fid, Integer uid){
        ul.deleteFeedback(fid, uid);
    }
    
    public Collection<Feedback> getAllFeedback(){
        return al.getAllFeedback();
    }
    
}
