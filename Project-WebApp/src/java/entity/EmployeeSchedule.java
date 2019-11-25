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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author andreashenriksson
 */
@Entity
public class EmployeeSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEESCHEDULEID")
    private Long employeeScheduleid;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATEDAY")
    private Date dateDay;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LUNCHSHIFT")
    private Person lunchPerson;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DINNERSHIFT")
    private Person DinnerPerson;
    
    public Long getEmployeeScheduleid() {
        return employeeScheduleid;
    }

    public void setEmployeeScheduleid(Long employeeScheduleid) {
        this.employeeScheduleid = employeeScheduleid;
    }

    public Date getDateDay() {
        return dateDay;
    }

    public void setDateDay(Date dateDay) {
        this.dateDay = dateDay;
    }
    
    public Person getLunchPerson() {
        return lunchPerson;
    }

    public void setLunchPerson(Person lunchPerson) {
        this.lunchPerson = lunchPerson;
    }

    public Person getDinnerPerson() {
        return DinnerPerson;
    }

    public void setDinnerPerson(Person DinnerPerson) {
        this.DinnerPerson = DinnerPerson;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeScheduleid != null ? employeeScheduleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeSchedule)) {
            return false;
        }
        EmployeeSchedule other = (EmployeeSchedule) object;
        if ((this.employeeScheduleid == null && other.employeeScheduleid != null) || (this.employeeScheduleid != null && !this.employeeScheduleid.equals(other.employeeScheduleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EmployeeSchedule[ employeeScheduleid=" + employeeScheduleid + " ]";
    }
    
}
