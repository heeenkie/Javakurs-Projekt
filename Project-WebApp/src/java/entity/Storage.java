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
@Table(name = "STORAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s"),
    @NamedQuery(name = "Storage.findByStorageid", query = "SELECT s FROM Storage s WHERE s.storageid = :storageid"),
    @NamedQuery(name = "Storage.findByDry", query = "SELECT s FROM Storage s WHERE s.dry = :dry"),
    @NamedQuery(name = "Storage.findByFrozen", query = "SELECT s FROM Storage s WHERE s.frozen = :frozen"),
    @NamedQuery(name = "Storage.findByFridge", query = "SELECT s FROM Storage s WHERE s.fridge = :fridge")})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STORAGEID")
    private Integer storageid;
    @Size(max = 15)
    @Column(name = "DRY")
    private String dry;
    @Size(max = 15)
    @Column(name = "FROZEN")
    private String frozen;
    @Size(max = 15)
    @Column(name = "FRIDGE")
    private String fridge;

    public Storage() {
    }

    public Storage(Integer storageid) {
        this.storageid = storageid;
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }

    public String getDry() {
        return dry;
    }

    public void setDry(String dry) {
        this.dry = dry;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getFridge() {
        return fridge;
    }

    public void setFridge(String fridge) {
        this.fridge = fridge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storageid != null ? storageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.storageid == null && other.storageid != null) || (this.storageid != null && !this.storageid.equals(other.storageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Storage[ storageid=" + storageid + " ]";
    }
    
}
