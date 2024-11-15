/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f"),
    @NamedQuery(name = "Form.findByFormId", query = "SELECT f FROM Form f WHERE f.formId = :formId"),
    @NamedQuery(name = "Form.findByFname", query = "SELECT f FROM Form f WHERE f.fname = :fname"),
    @NamedQuery(name = "Form.findByMno", query = "SELECT f FROM Form f WHERE f.mno = :mno"),
    @NamedQuery(name = "Form.findByGender", query = "SELECT f FROM Form f WHERE f.gender = :gender"),
    @NamedQuery(name = "Form.findByDob", query = "SELECT f FROM Form f WHERE f.dob = :dob"),
    @NamedQuery(name = "Form.findByHeight", query = "SELECT f FROM Form f WHERE f.height = :height"),
    @NamedQuery(name = "Form.findByWeight", query = "SELECT f FROM Form f WHERE f.weight = :weight"),
    @NamedQuery(name = "Form.findByAddress", query = "SELECT f FROM Form f WHERE f.address = :address")})
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "form_id")
    private Integer formId;
    @Size(max = 100)
    @Column(name = "fname")
    private String fname;
    @Column(name = "mno")
    private BigInteger mno;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private UserMst uid;

    public Form() {
    }

    public Form(Integer formId) {
        this.formId = formId;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public UserMst getUid() {
        return uid;
    }

    public void setUid(UserMst uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formId != null ? formId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.formId == null && other.formId != null) || (this.formId != null && !this.formId.equals(other.formId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Form[ formId=" + formId + " ]";
    }
    
}
