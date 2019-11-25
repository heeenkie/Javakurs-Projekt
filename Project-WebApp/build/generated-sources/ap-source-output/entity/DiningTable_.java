package entity;

import entity.Ordering;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T17:06:16")
@StaticMetamodel(DiningTable.class)
public class DiningTable_ { 

    public static volatile SingularAttribute<DiningTable, Integer> number;
    public static volatile SingularAttribute<DiningTable, Integer> diningTableid;
    public static volatile ListAttribute<DiningTable, Ordering> orderings;
    public static volatile SingularAttribute<DiningTable, Integer> capacity;

}