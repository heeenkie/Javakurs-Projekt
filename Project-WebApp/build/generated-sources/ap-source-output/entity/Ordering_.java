package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-30T15:24:11")
@StaticMetamodel(Ordering.class)
public class Ordering_ { 

    public static volatile SingularAttribute<Ordering, Date> ordertime;
    public static volatile SingularAttribute<Ordering, Boolean> isDone;
    public static volatile SingularAttribute<Ordering, Integer> orderingid;

}