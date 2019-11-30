/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Menu;
import entity.Person;
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
@Named(value = "personBean")
@SessionScoped
public class PersonBean implements Serializable{
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
     
    public PersonBean() {
    }
    
    public void persist(Person entity) {
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
    
    public void delete(Person entity) {
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
    
    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> pList = em.createNamedQuery("Person.findAll").getResultList();
        em.close();
        return pList;
    }
    
    public Person findById(Integer personid) {
        EntityManager em = emf.createEntityManager();
        Person p = (Person) em.createNamedQuery("Person.findByPersonid").setParameter("personid", personid).getSingleResult();
        em.close();
        return p;
    }
}
