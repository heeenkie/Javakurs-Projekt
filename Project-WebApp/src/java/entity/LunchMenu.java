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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreashenriksson
 */
@Entity
@Table(name = "LUNCHMENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LunchMenu.findAll", query = "SELECT lm FROM LunchMenu lm"),
    @NamedQuery(name = "LunchMenu.findByLunchMenuid", query = "SELECT lm FROM LunchMenu lm WHERE lm.lunchMenuid = :lunchMenuid")
})
public class LunchMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LUNCHMENUID")
    private Integer lunchMenuid;
    
    @NotNull
    @Max(value = 52)
    @Min(value = 1)
    @Column(name = "WEEKNUMBER")
    private Integer weekNumber;

    @Column(name = "MONDAY")
    private String monday;
    
    @Column(name = "TUESDAY")
    private String tuesday;
    
    @Column(name = "WEDNESDAY")
    private String wednesday;
    
    @Column(name = "THURSDAY")
    private String thursday;
    
    @Column(name = "FRIDAY")
    private String friday;

    
    public Integer getLunchMenuid() {
        return lunchMenuid;
    }

    public void setLunchMenuid(Integer lunchMenuid) {
        this.lunchMenuid = lunchMenuid;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lunchMenuid != null ? lunchMenuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LunchMenu)) {
            return false;
        }
        LunchMenu other = (LunchMenu) object;
        if ((this.lunchMenuid == null && other.lunchMenuid != null) || (this.lunchMenuid != null && !this.lunchMenuid.equals(other.lunchMenuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LunchMenu[ lunchMenuid=" + lunchMenuid + " ]";
    }
    
}
