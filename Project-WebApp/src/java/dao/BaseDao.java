/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author andreashenriksson
 */
public abstract class BaseDao<T> {
    private Class<T> entity;
    
    public BaseDao(Class<T> entity){
        this.entity = entity;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void persist(T entity) {
     //   em.persist(entity);
    }
}
