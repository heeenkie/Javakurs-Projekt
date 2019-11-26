/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Ordering;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "orderingBean")
@SessionScoped
public class OrderingBean implements Serializable {
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
     
    public OrderingBean() {
    }
        
    public void persist(Ordering entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Ordering entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public List<Ordering> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Ordering> oList = em.createNamedQuery("Ordering.findAll").getResultList();
        em.close();
        return oList;
    }
    
    public Ordering findById(Integer orderingid) {
        EntityManager em = emf.createEntityManager();
        Ordering o = (Ordering) em.createNamedQuery("Ordering.findByOrderingid").setParameter("orderingid", orderingid).getSingleResult();
        em.close();
        return o;
    }
    
}
