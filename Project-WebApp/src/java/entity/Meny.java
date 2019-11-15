/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreashenriksson
 */
@Entity
@Table(name = "MENY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meny.findAll", query = "SELECT m FROM Meny m"),
    @NamedQuery(name = "Meny.findByMenyid", query = "SELECT m FROM Meny m WHERE m.menyid = :menyid"),
    @NamedQuery(name = "Meny.findByDescription", query = "SELECT m FROM Meny m WHERE m.description = :description"),
    @NamedQuery(name = "Meny.findByPrice", query = "SELECT m FROM Meny m WHERE m.price = :price")})
public class Meny implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENYID")
    private Integer menyid;
    @Size(max = 64)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public Meny() {
    }

    public Meny(Integer menyid) {
        this.menyid = menyid;
    }

    public Integer getMenyid() {
        return menyid;
    }

    public void setMenyid(Integer menyid) {
        this.menyid = menyid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menyid != null ? menyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meny)) {
            return false;
        }
        Meny other = (Meny) object;
        if ((this.menyid == null && other.menyid != null) || (this.menyid != null && !this.menyid.equals(other.menyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Meny[ menyid=" + menyid + " ]";
    }
    
}
