package entity;

import entity.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-26T17:15:18")
@StaticMetamodel(EmployeeSchedule.class)
public class EmployeeSchedule_ { 

    public static volatile SingularAttribute<EmployeeSchedule, Person> lunchPerson;
    public static volatile SingularAttribute<EmployeeSchedule, Date> dateDay;
    public static volatile SingularAttribute<EmployeeSchedule, Long> employeeScheduleid;
    public static volatile SingularAttribute<EmployeeSchedule, Person> DinnerPerson;

}