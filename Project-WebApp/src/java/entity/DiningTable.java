/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author andreashenriksson
 */
@Entity
public class DiningTable implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DININGTABLEID")
    private Integer diningTableid;
    
    @Column(name = "NUMBER")
    private Integer number;
    
    @Column(name = "CAPACITY")
    private Integer capacity;

    public Integer getDiningTableid() {
        return diningTableid;
    }

    public void setDiningTableid(Integer diningTableid) {
        this.diningTableid = diningTableid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diningTableid != null ? diningTableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiningTable)) {
            return false;
        }
        DiningTable other = (DiningTable) object;
        if ((this.diningTableid == null && other.diningTableid != null) || (this.diningTableid != null && !this.diningTableid.equals(other.diningTableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DiningTable[ diningTableid=" + diningTableid + " ]";
    }
    
}
