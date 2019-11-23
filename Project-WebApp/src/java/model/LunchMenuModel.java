/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author feliciaasplund
 */
@Named(value = "lunchMenuModel")
@RequestScoped
public class LunchMenuModel {
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    /**
     * @return the monday
     */
    public String getMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public String getFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(String friday) {
        this.friday = friday;
    }

    
}
