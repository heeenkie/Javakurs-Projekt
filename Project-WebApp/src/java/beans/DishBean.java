/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Dish;
import java.io.Serializable;
import java.util.ArrayList;
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

@Named(value = "dishBean")
@SessionScoped
public class DishBean implements Serializable {
    private Dish dish;
    private List<Dish> dishes;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    
    public DishBean() {
    }
     
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public List<Dish> getDishes() {
        return findAll();
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    
    public void save() {
        persist(this.dish);
        this.dish = new Dish();
        this.dishes = findAll();
    }
    public void persist(Dish entity) {
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
    
    public void delete(Dish entity) {
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
    
    public List<Dish> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Dish> dList = em.createNamedQuery("Dish.findAll").getResultList();
        em.close();
        return dList;
    }
    
    public Dish findById(Integer dishid) {
        EntityManager em = emf.createEntityManager();
        Dish d = (Dish) em.createNamedQuery("Dish.findByDishid").setParameter("dishid", dishid).getSingleResult();
        em.close();
        return d;
    }  

}
