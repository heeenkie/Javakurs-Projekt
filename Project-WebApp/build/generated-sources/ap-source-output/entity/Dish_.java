package entity;

import entity.Ordering;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-29T20:38:41")
@StaticMetamodel(Dish.class)
public class Dish_ { 

    public static volatile SingularAttribute<Dish, Double> price;
    public static volatile SingularAttribute<Dish, Integer> dishid;
    public static volatile SingularAttribute<Dish, String> name;
    public static volatile ListAttribute<Dish, Ordering> orderings;
    public static volatile SingularAttribute<Dish, Integer> cookingTime;

}