/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "menyDao")
@RequestScoped
public class MenyDao {

    /**
     * Creates a new instance of menyDao
     */
    public MenyDao() {
    }
    
}
