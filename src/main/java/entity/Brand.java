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
import jakarta.persistence.Lob;
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
@Table(name = "brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findByBid", query = "SELECT b FROM Brand b WHERE b.bid = :bid"),
    @NamedQuery(name = "Brand.findByBname", query = "SELECT b FROM Brand b WHERE b.bname = :bname"),
    @NamedQuery(name = "Brand.findByManufacturer", query = "SELECT b FROM Brand b WHERE b.manufacturer = :manufacturer"),
    @NamedQuery(name = "Brand.findByCountryOrigin", query = "SELECT b FROM Brand b WHERE b.countryOrigin = :countryOrigin"),
    @NamedQuery(name = "Brand.findBySiteUrl", query = "SELECT b FROM Brand b WHERE b.siteUrl = :siteUrl")})
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Integer bid;
    @Size(max = 100)
    @Column(name = "bname")
    private String bname;
    @Lob
    @Column(name = "bimg")
    private byte[] bimg;
    @Size(max = 100)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Size(max = 50)
    @Column(name = "country_origin")
    private String countryOrigin;
    @Size(max = 255)
    @Column(name = "site_url")
    private String siteUrl;
    @OneToMany(mappedBy = "bid")
    private Collection<Medicine> medicineCollection;

    public Brand() {
    }

    public Brand(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public byte[] getBimg() {
        return bimg;
    }

    public void setBimg(byte[] bimg) {
        this.bimg = bimg;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @XmlTransient
    public Collection<Medicine> getMedicineCollection() {
        return medicineCollection;
    }

    public void setMedicineCollection(Collection<Medicine> medicineCollection) {
        this.medicineCollection = medicineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Brand[ bid=" + bid + " ]";
    }
    
}
