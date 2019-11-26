/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.LunchMenu;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "lunchMenuBean")
@SessionScoped
public class LunchMenuBean implements Serializable{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    
    public LunchMenuBean() {
    }

    public void persist(LunchMenu entity) {
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
    
    public void delete(LunchMenu entity) {
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
    
    public List<LunchMenu> findAll() {
        EntityManager em = emf.createEntityManager();
        List<LunchMenu> lList = em.createNamedQuery("LunchMenu.findAll").getResultList();
        em.close();
        return lList;
    }
    
    public LunchMenu findById(Integer lunchMenuid) {
        EntityManager em = emf.createEntityManager();
        LunchMenu l = (LunchMenu) em.createNamedQuery("LunchMenu.findByLunchMenuid").setParameter("lunchMenuid", lunchMenuid).getSingleResult();
        em.close();
        return l;
    }
    
}
