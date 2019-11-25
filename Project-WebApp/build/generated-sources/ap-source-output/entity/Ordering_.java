package entity;

import entity.DiningTable;
import entity.Dish;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T17:06:16")
@StaticMetamodel(Ordering.class)
public class Ordering_ { 

    public static volatile SingularAttribute<Ordering, DiningTable> diningTable;
    public static volatile ListAttribute<Ordering, Dish> dishes;
    public static volatile SingularAttribute<Ordering, Date> ordertime;
    public static volatile SingularAttribute<Ordering, Boolean> isDone;
    public static volatile SingularAttribute<Ordering, Integer> orderingid;

}