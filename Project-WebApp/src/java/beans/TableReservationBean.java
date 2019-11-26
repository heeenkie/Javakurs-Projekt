/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.LunchMenu;
import entity.TableReservation;
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
@Named(value = "tableReservationBean")
@SessionScoped
public class TableReservationBean implements Serializable {
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
     
    public TableReservationBean() {
    }
    
    
    public void persist(TableReservation entity) {
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
    
    public void delete(TableReservation entity) {
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
    
    public List<TableReservation> findAll() {
        EntityManager em = emf.createEntityManager();
        List<TableReservation> trList = em.createNamedQuery("TableReservation.findAll").getResultList();
        em.close();
        return trList;
    }
    
    public TableReservation findById(Integer tableReservationid) {
        EntityManager em = emf.createEntityManager();
        TableReservation tr = (TableReservation) em.createNamedQuery("TableReservation.findByTableReservationid").setParameter("tableReservationid", tableReservationid).getSingleResult();
        em.close();
        return tr;
    }
    
    
}
