package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T23:09:11")
@StaticMetamodel(TableReservation.class)
public class TableReservation_ { 

    public static volatile SingularAttribute<TableReservation, String> nameOfBooker;
    public static volatile SingularAttribute<TableReservation, Integer> bookedTable;
    public static volatile SingularAttribute<TableReservation, Date> startTime;
    public static volatile SingularAttribute<TableReservation, Integer> tableReservationid;

}