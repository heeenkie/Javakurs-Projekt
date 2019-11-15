/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andreashenriksson
 * @param <T>
*/
public abstract class BaseDao<T> {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    EntityManager em = emf.createEntityManager();

    public void persist(T t) {
        try {
            em.getTransaction().begin();
            if (em.contains(t)) {
                em.merge(t);
            }
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught dureing persist", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void delete(T t) {
        try{
            em.getTransaction().begin();
            if (em.contains(t)){
                em.remove(t);
                em.getTransaction().commit();
            }
        }
        catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Exception cought during remove", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    } 
}
