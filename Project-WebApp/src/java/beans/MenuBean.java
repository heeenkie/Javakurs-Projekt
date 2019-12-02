/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Menu;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author viktorandersson
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {
    private Menu menu;
    /**
     * Creates a new instance of MenuBean
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    
    public MenuBean() {
    }
    
    public void persist(Menu entity) {
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
    
    public void delete(Menu entity) {
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
    
    public List<Menu> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Menu> dList = em.createNamedQuery("Menu.findAll").getResultList();
        em.close();
        return dList;
    }
    
    public Menu findById(Integer menuid) {
        EntityManager em = emf.createEntityManager();
        return (Menu)em.createNamedQuery("Menu.findByMenuid").setParameter("menuid", menuid).getSingleResult();
    }  
    
}
