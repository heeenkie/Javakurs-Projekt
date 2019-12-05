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
@Table(name = "DISH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d"),
    @NamedQuery(name = "Dish.findByDishid", query = "SELECT d FROM Dish d WHERE d.dishid = :dishid"),
    @NamedQuery(name = "Dish.findByOrderNumber", query = "SELECT d FROM Dish d WHERE d.orderNumber = :orderNumber")
})
public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "DISHID")
    private Integer dishid;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private Double price;
      
    @Column(name = "COOKINGTIME")
    private Integer cookingTime; 
    
    @Column(name = "ORDERNUMBER")
    private Integer orderNumber;
    
    @Column(name = "TABLENUMBER")
    private Integer tableNumber;
    
    @Column(name = "DONE")
    private Boolean done;
    
    public Dish() {
    }

    public Integer getDishid() {
        return dishid;
    }

    public void setDishid(Integer dishid) {
        this.dishid = dishid;
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
    
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dishid != null ? dishid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.dishid == null && other.dishid != null) || (this.dishid != null && !this.dishid.equals(other.dishid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dishid +  ",   " + name + ",     Price: " + price + ",     Cooking Time: " + cookingTime;
    }


}
