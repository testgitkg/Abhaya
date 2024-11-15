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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOid", query = "SELECT o FROM Order1 o WHERE o.oid = :oid"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByTotalAmt", query = "SELECT o FROM Order1 o WHERE o.totalAmt = :totalAmt"),
    @NamedQuery(name = "Order1.findByPaymentStatus", query = "SELECT o FROM Order1 o WHERE o.paymentStatus = :paymentStatus"),
    @NamedQuery(name = "Order1.findByPaymentMethod", query = "SELECT o FROM Order1 o WHERE o.paymentMethod = :paymentMethod")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oid")
    private Integer oid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 9)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amt")
    private BigDecimal totalAmt;
    @Lob
    @Size(max = 65535)
    @Column(name = "shipping_add")
    private String shippingAdd;
    @Size(max = 7)
    @Column(name = "payment_status")
    private String paymentStatus;
    @Size(max = 50)
    @Column(name = "payment_method")
    private String paymentMethod;
    @OneToMany(mappedBy = "oid")
    private Collection<OrderItem> orderItemCollection;
    @OneToMany(mappedBy = "oid")
    private Collection<OrderManage> orderManageCollection;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private UserMst uid;

    public Order1() {
    }

    public Order1(Integer oid) {
        this.oid = oid;
    }

    public Order1(Integer oid, Date orderDate) {
        this.oid = oid;
        this.orderDate = orderDate;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getShippingAdd() {
        return shippingAdd;
    }

    public void setShippingAdd(String shippingAdd) {
        this.shippingAdd = shippingAdd;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @XmlTransient
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
    }

    @XmlTransient
    public Collection<OrderManage> getOrderManageCollection() {
        return orderManageCollection;
    }

    public void setOrderManageCollection(Collection<OrderManage> orderManageCollection) {
        this.orderManageCollection = orderManageCollection;
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
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Order1[ oid=" + oid + " ]";
    }
    
}
