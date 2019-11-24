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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreashenriksson
 */
@Entity
@Table(name = "TABLERESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReservation.findAll", query = "SELECT tr FROM TableReservation tr"),
    @NamedQuery(name = "TableReservation.findByTableReservationid", query = "SELECT tr FROM TableReservation tr WHERE tr.tableReservationid = :tableReservationid")
})
public class TableReservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TABLERESERVATIONID")
    private Integer tableReservationid;

    @Column(name = "NAMEOFBOOKER")
    private String nameOfBooker;
         
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTTIME")
    private Date startTime;
    
    @Column(name = "BOOKEDTABLE")
    private Integer bookedTable;
    
    public TableReservation() {
    }
        
    public Integer getTableReservationid() {
        return tableReservationid;
    }

    public void setTableReservationid(Integer tableReservationid) {
        this.tableReservationid = tableReservationid;
    }

    public String getNameOfBooker() {
        return nameOfBooker;
    }

    public void setNameOfBooker(String nameOfBooker) {
        this.nameOfBooker = nameOfBooker;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getBookedTable() {
        return bookedTable;
    }

    public void setBookedTable(Integer bookedTable) {
        this.bookedTable = bookedTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableReservationid != null ? tableReservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableReservation)) {
            return false;
        }
        TableReservation other = (TableReservation) object;
        if ((this.tableReservationid == null && other.tableReservationid != null) || (this.tableReservationid != null && !this.tableReservationid.equals(other.tableReservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TableReservation[ id=" + tableReservationid + " ]";
    }
    
}
