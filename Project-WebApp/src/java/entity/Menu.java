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
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuid", query = "SELECT m FROM Menu m WHERE m.menuid = :menuid")
})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MENUID")
    private Integer menuid;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private Double price;
      
    @Column(name = "COOKINGTIME")
    private Integer cookingTime; 
    
    public Menu() {
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
    
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getMenuid() != null ? getMenuid().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.getMenuid() == null && other.getMenuid() != null) || (this.getMenuid() != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " " + price.intValue() + " kr";
    }

}
