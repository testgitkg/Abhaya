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
import jakarta.persistence.Lob;
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
@Table(name = "medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m"),
    @NamedQuery(name = "Medicine.findByMid", query = "SELECT m FROM Medicine m WHERE m.mid = :mid"),
    @NamedQuery(name = "Medicine.findByMname", query = "SELECT m FROM Medicine m WHERE m.mname = :mname"),
    @NamedQuery(name = "Medicine.findByDescription", query = "SELECT m FROM Medicine m WHERE m.description = :description"),
    @NamedQuery(name = "Medicine.findByPrice", query = "SELECT m FROM Medicine m WHERE m.price = :price"),
    @NamedQuery(name = "Medicine.findByQuantity", query = "SELECT m FROM Medicine m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "Medicine.findByAvailability", query = "SELECT m FROM Medicine m WHERE m.availability = :availability")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mid")
    private Integer mid;
    @Size(max = 100)
    @Column(name = "mname")
    private String mname;
    @Lob
    @Size(max = 65535)
    @Column(name = "img")
    private String img;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Size(max = 50)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 50)
    @Column(name = "availability")
    private String availability;
    @JsonbTransient
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    @ManyToOne
    private Brand bid;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne
    private Category catId;
    @OneToMany(mappedBy = "mid")
    private Collection<InventoryManage> inventoryManageCollection;
    @OneToMany(mappedBy = "mid")
    private Collection<OrderItem> orderItemCollection;
    @OneToMany(mappedBy = "mid")
    private Collection<CartItem> cartItemCollection;

    public Medicine() {
    }

    public Medicine(Integer mid) {
        this.mid = mid;
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

    public Brand getBid() {
        return bid;
    }

    public void setBid(Brand bid) {
        this.bid = bid;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @JsonbTransient
    public Collection<InventoryManage> getInventoryManageCollection() {
        return inventoryManageCollection;
    }

    public void setInventoryManageCollection(Collection<InventoryManage> inventoryManageCollection) {
        this.inventoryManageCollection = inventoryManageCollection;
    }

    @JsonbTransient
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
    }

    @JsonbTransient
    public Collection<CartItem> getCartItemCollection() {
        return cartItemCollection;
    }

    public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
        this.cartItemCollection = cartItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medicine[ mid=" + mid + " ]";
    }
    
}
