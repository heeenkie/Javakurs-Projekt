package entity;

import entity.Ordering;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T23:09:11")
@StaticMetamodel(Dish.class)
public class Dish_ { 

    public static volatile SingularAttribute<Dish, Double> price;
    public static volatile SingularAttribute<Dish, Integer> dishid;
    public static volatile SingularAttribute<Dish, String> name;
    public static volatile SingularAttribute<Dish, String> description;
    public static volatile ListAttribute<Dish, Ordering> orderings;

}