package com.papers.model;

import com.papers.model.Invoice;
import com.papers.model.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-08T12:33:33")
@StaticMetamodel(InvoiceDetail.class)
public class InvoiceDetail_ { 

    public static volatile SingularAttribute<InvoiceDetail, Float> totalValue;
    public static volatile SingularAttribute<InvoiceDetail, Item> item;
    public static volatile SingularAttribute<InvoiceDetail, Integer> quantity;
    public static volatile SingularAttribute<InvoiceDetail, Integer> id;
    public static volatile SingularAttribute<InvoiceDetail, Invoice> invoice;
    public static volatile SingularAttribute<InvoiceDetail, String> state;
    public static volatile SingularAttribute<InvoiceDetail, Float> unitValue;

}