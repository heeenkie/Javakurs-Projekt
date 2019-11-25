package entity;

import entity.Dish;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T23:09:11")
@StaticMetamodel(Ordering.class)
public class Ordering_ { 

    public static volatile ListAttribute<Ordering, Dish> dishes;
    public static volatile SingularAttribute<Ordering, Date> ordertime;
    public static volatile SingularAttribute<Ordering, Integer> orderingid;

}