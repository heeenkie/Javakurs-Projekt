/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dish;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "dishDao")
@RequestScoped
public class DishDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");

    
    public DishDao() {
    }
    
    public List<Dish> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Dish.findAll").getResultList();
    }
    
    public Dish findById(Integer dishid) {
        EntityManager em = emf.createEntityManager();
        return (Dish) em.createNamedQuery("Dish.findByDishid").setParameter("dishid", dishid).getSingleResult();
    }
    
    public void persist(Dish dish) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dish);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Dish dish) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(dish);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
