/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DishDao;
import dao.OrderingDao;
import entity.Dish;
import entity.Ordering;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "testModel")
@RequestScoped
public class TestModel {
    
    DishDao dishDao;
    OrderingDao orderingDao;
    private Integer pos;
    
    private Dish dish;
    private List<Dish> dishes;
    private Ordering ordering;
    private List<Ordering> orderings;
    
    public TestModel() {
        dishDao = new DishDao();
        orderingDao = new OrderingDao();
        dish = new Dish();
        ordering = new Ordering();
        updateDishes();
        updateOrderings();
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
    
    public void saveDish() {
        if (this.dish != null) {
            dishDao.persist(this.dish);
            updateDishes();
            dish = new Dish();
        }

    }
    
    public void saveOrdering() {
        if (this.ordering != null) {
            if (pos != null) {
                for(int i=0; i<getDishes().size(); i++){
                    this.ordering.addDish(getDishes().get(1));
                }
            }
            orderingDao.persist(this.ordering);
            updateOrderings();
            ordering = new Ordering();
        }
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    
    private void updateDishes() {
        setDishes(dishDao.findAll());
    }
    
    private void updateOrderings() {
        setOrderings(orderingDao.findAll());
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public List<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(List<Ordering> orderings) {
        this.orderings = orderings;
    }
   
    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}
