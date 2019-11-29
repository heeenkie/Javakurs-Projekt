/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Dish;
import java.lang.annotation.Annotation;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author andreashenriksson
 */
@ManagedBean(name = "dishConverterBean")
@FacesConverter(value = "dishConverter")
public class DishConverter implements Converter{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project-WebAppPU");
    
    // I include this because you will need to 
    // lookup  your entities based on submitted values
    private transient EntityManager em;  

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Dish.findByDishid").setParameter("dishid", Integer.valueOf(value)).getSingleResult();
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        return ((Dish)t).getDishid().toString();
        
    }

}
