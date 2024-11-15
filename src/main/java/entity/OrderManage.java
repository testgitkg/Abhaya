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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "order_manage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderManage.findAll", query = "SELECT o FROM OrderManage o"),
    @NamedQuery(name = "OrderManage.findByManageId", query = "SELECT o FROM OrderManage o WHERE o.manageId = :manageId"),
    @NamedQuery(name = "OrderManage.findByStatus", query = "SELECT o FROM OrderManage o WHERE o.status = :status"),
    @NamedQuery(name = "OrderManage.findByTimestamp", query = "SELECT o FROM OrderManage o WHERE o.timestamp = :timestamp")})
public class OrderManage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manage_id")
    private Integer manageId;
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    @ManyToOne
    private Order1 oid;

    public OrderManage() {
    }

    public OrderManage(Integer manageId) {
        this.manageId = manageId;
    }

    public OrderManage(Integer manageId, Date timestamp) {
        this.manageId = manageId;
        this.timestamp = timestamp;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Order1 getOid() {
        return oid;
    }

    public void setOid(Order1 oid) {
        this.oid = oid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manageId != null ? manageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderManage)) {
            return false;
        }
        OrderManage other = (OrderManage) object;
        if ((this.manageId == null && other.manageId != null) || (this.manageId != null && !this.manageId.equals(other.manageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderManage[ manageId=" + manageId + " ]";
    }
    
}
