/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Dish.findByDishid", query = "SELECT d FROM Dish d WHERE d.dishid = :dishid")
})
public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "DISHID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer dishid;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "NAME")
    private String name;
    
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @NotNull
    @Min(value=0)
    @Column(name = "PRICE")
    private Double price;
      
    @ManyToMany(mappedBy = "dishes")
    private List<Ordering> orderings;
        
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

    public List<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(List<Ordering> orderings) {
        this.orderings = orderings;
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
        return "entity.Dish[ name=" + name + " ]";
    }
}
