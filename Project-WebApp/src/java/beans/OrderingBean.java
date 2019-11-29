/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Dish;
import entity.Ordering;
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
@Named(value = "orderingBean")
@SessionScoped
public class OrderingBean implements Serializable {
    private List<Ordering> orderings;
    private Ordering ordering;
    private ArrayList<Dish> selectedDishes;
    private Dish dish;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
     
    public OrderingBean() {
        orderings = new ArrayList<>();
        ordering = null;
        selectedDishes = new ArrayList<>();
        dish = null;
    }
        
    public List<Ordering> getOrderings() {
        return findAll();
    }

    public void setOrderings(List<Ordering> orderings) {
        this.orderings = orderings;
    }

    public List<Dish> getSelectedDishes() {
        return selectedDishes;
    }

    public void setSelectedDishes(ArrayList<Dish> selectedDishes) {
        this.selectedDishes = selectedDishes;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
    
    public void addDish() {
        if (dish != null) {
          //  selectedDishes.add(dish); //Does not work
            dish = null;
        }
    }
    
    public void addOrdering() {
        if (ordering != null  && selectedDishes.isEmpty()) {
            ordering.setDishes(selectedDishes);
            persist(ordering);
            ordering = null;
            selectedDishes = null;
        }
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
