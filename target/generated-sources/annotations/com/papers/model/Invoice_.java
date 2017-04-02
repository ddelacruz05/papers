package com.papers.model;

import com.papers.model.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T22:00:18")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, String> reference;
    public static volatile SingularAttribute<Invoice, Float> totalValue;
    public static volatile SingularAttribute<Invoice, Float> iva;
    public static volatile SingularAttribute<Invoice, Float> netValue;
    public static volatile SingularAttribute<Invoice, Integer> id;
    public static volatile SingularAttribute<Invoice, Date> saleDate;
    public static volatile SingularAttribute<Invoice, String> state;
    public static volatile SingularAttribute<Invoice, Customer> customer;

}