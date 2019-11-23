/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreashenriksson
 */
@Entity
@Table(name = "ORDERING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o"),
    @NamedQuery(name = "Ordering.findByOrderingid", query = "SELECT o FROM Ordering o WHERE o.orderingid = :orderingid")})
public class Ordering implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "ORDERINGID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderingid;
    
    @Column(name = "TIMESTAMP")
    private Date timestamp;
    
    public Ordering() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        if (timestamp != null) {
            this.timestamp = new Date();
        } else {
            this.timestamp = null;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderingid != null ? orderingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.orderingid == null && other.orderingid != null) || (this.orderingid != null && !this.orderingid.equals(other.orderingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ordering[ orderingid=" + orderingid + " ]";
    }
}
