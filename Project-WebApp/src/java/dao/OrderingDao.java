/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ordering;
import java.util.List;
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
 */
@Named(value = "orderingDao")
@RequestScoped
public class OrderingDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    
    
    public OrderingDao() {
        
    }
    
    public List<Ordering> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Ordering.findAll").getResultList();
    }
    
    public Ordering findById(Integer orderingid) {
        EntityManager em = emf.createEntityManager();
        return (Ordering) em.createNamedQuery("Ordering.findByOrderingid").setParameter("orderingid", orderingid).getSingleResult();
    }
    
    public void persist(Ordering ordering) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ordering);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Ordering ordering) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(ordering);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
