package com.papers.model;

import com.papers.model.Provider;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T22:00:18")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, String> reference;
    public static volatile SingularAttribute<PurchaseOrder, Float> totalValue;
    public static volatile SingularAttribute<PurchaseOrder, Date> purchaseDate;
    public static volatile SingularAttribute<PurchaseOrder, Provider> provider;
    public static volatile SingularAttribute<PurchaseOrder, Float> iva;
    public static volatile SingularAttribute<PurchaseOrder, Float> netValue;
    public static volatile SingularAttribute<PurchaseOrder, Float> ice;
    public static volatile SingularAttribute<PurchaseOrder, Integer> id;
    public static volatile SingularAttribute<PurchaseOrder, String> state;

}