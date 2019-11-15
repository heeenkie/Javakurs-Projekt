/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Meny;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "menyDao")
@RequestScoped
public class MenyDao extends BaseDao<Meny>{

    public MenyDao() {
    }
    
}
