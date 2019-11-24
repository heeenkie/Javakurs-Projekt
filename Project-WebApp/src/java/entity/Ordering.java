/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Ordering.findByOrderingid", query = "SELECT o FROM Ordering o WHERE o.orderingid = :orderingid")
})
public class Ordering implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "ORDERINGID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderingid;
    
    @Column(name = "TIMESTAMP")
    private Date timestamp;
    
    @ManyToMany
    @JoinTable(
        name = "DISH_ORDERING", 
        joinColumns = @JoinColumn(name = "ORDERINGID"), 
        inverseJoinColumns = @JoinColumn(name = "DISHID")
    )
    private List<Dish> dishes;
    
    public Ordering() {
    }

        public Integer getOrderingid() {
        return orderingid;
    }

    public void setOrderingid(Integer orderingid) {
        this.orderingid = orderingid;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }
    
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    
    public void addDish(Dish dish) {
        getDishes().add(dish);
        dish.getOrderings().add(this);
    }
 
    public void removeDish(Dish dish) {
        getDishes().remove(dish);
        dish.getOrderings().remove(this);
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getOrderingid() != null ? getOrderingid().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.getOrderingid() == null && other.getOrderingid() != null) || (this.getOrderingid() != null && !this.orderingid.equals(other.orderingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ordering[ orderingid=" + getOrderingid() + " ]";
    }


}
