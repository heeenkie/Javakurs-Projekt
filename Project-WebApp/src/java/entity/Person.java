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

@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonid", query = "SELECT p FROM Person p WHERE p.personid = :personid")
})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PERSONID")
    private Integer personid;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "FULLTIMEEMPLOYEE")
    private Boolean fulltimeEmployee;
    
    public Person() {
    }
   
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFulltimeEmployee() {
        return fulltimeEmployee;
    }

    public void setFulltimeEmployee(Boolean fulltimeEmployee) {
        this.fulltimeEmployee = fulltimeEmployee;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getPersonid() != null ? getPersonid().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.getPersonid() == null && other.getPersonid() != null) || (this.getPersonid() != null && !this.personid.equals(other.personid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ personid=" + getPersonid() + " ]";
    }
}