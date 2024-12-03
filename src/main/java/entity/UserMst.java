/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.json.bind.annotation.JsonbTransient;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "user_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMst.findAll", query = "SELECT u FROM UserMst u"),
    @NamedQuery(name = "UserMst.findByUid", query = "SELECT u FROM UserMst u WHERE u.uid = :uid"),
    @NamedQuery(name = "UserMst.findByUname", query = "SELECT u FROM UserMst u WHERE u.uname = :uname"),
    @NamedQuery(name = "UserMst.findByEmail", query = "SELECT u FROM UserMst u WHERE u.email = :email"),
    @NamedQuery(name = "UserMst.findByPassword", query = "SELECT u FROM UserMst u WHERE u.password = :password"),
    @NamedQuery(name = "UserMst.findByAddress", query = "SELECT u FROM UserMst u WHERE u.address = :address")})
public class UserMst implements Serializable {

    @Size(max = 50)
    @Column(name = "uname")
    private String uname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 300)
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "uid")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(mappedBy = "uid")
    private Collection<Order1> order1Collection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid")
    private Integer uid;
    @JoinColumn(name = "rid", referencedColumnName = "rid")
    @ManyToOne
    private Role rid;

    public UserMst() {
    }

    public UserMst(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public Role getRid() {
        return rid;
    }

    public void setRid(Role rid) {
        this.rid = rid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMst)) {
            return false;
        }
        UserMst other = (UserMst) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserMst[ uid=" + uid + " ]";
    }
    @JsonbTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }
    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }
    
}
