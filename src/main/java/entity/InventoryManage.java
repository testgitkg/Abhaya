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
@Table(name = "inventory_manage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryManage.findAll", query = "SELECT i FROM InventoryManage i"),
    @NamedQuery(name = "InventoryManage.findByInventoryId", query = "SELECT i FROM InventoryManage i WHERE i.inventoryId = :inventoryId"),
    @NamedQuery(name = "InventoryManage.findByQuantity", query = "SELECT i FROM InventoryManage i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "InventoryManage.findByAction", query = "SELECT i FROM InventoryManage i WHERE i.action = :action"),
    @NamedQuery(name = "InventoryManage.findByActionDate", query = "SELECT i FROM InventoryManage i WHERE i.actionDate = :actionDate")})
public class InventoryManage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_id")
    private Integer inventoryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "action_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "mid", referencedColumnName = "mid")
    @ManyToOne(optional = false)
    private Medicine mid;
    @JoinColumn(name = "managed_by", referencedColumnName = "aid")
    @ManyToOne
    private Admin managedBy;

    public InventoryManage() {
    }

    public InventoryManage(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public InventoryManage(Integer inventoryId, int quantity, String action, Date actionDate) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.action = action;
        this.actionDate = actionDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Medicine getMid() {
        return mid;
    }

    public void setMid(Medicine mid) {
        this.mid = mid;
    }

    public Admin getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Admin managedBy) {
        this.managedBy = managedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryId != null ? inventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryManage)) {
            return false;
        }
        InventoryManage other = (InventoryManage) object;
        if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InventoryManage[ inventoryId=" + inventoryId + " ]";
    }
    
}
