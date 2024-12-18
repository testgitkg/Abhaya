/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.adminLocal;
import ejb.userLocal;
import entity.Form;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Named(value = "formCdi")
@RequestScoped
public class formCdi {
    
    @EJB adminLocal al;
    @EJB userLocal ul;
    
    Form f = new Form();
    Collection<Form> form;

    /**
     * Creates a new instance of formCdi
     */
    public formCdi() {
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Collection<Form> getForm() {
        return form;
    }

    public void setForm(Collection<Form> form) {
        this.form = form;
    }
    
    public void deleteForm(Integer form_id, Integer uid){
        ul.deleteForm(form_id, uid);
    }
    
    public Collection<Form> getAllForm(){
        return al.getAllForm();
    }
    
}
