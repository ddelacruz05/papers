package com.papers.model;

import com.papers.model.Item;
import com.papers.model.Provider;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T22:00:18")
@StaticMetamodel(PurchaseOrderDetail.class)
public class PurchaseOrderDetail_ { 

    public static volatile SingularAttribute<PurchaseOrderDetail, Float> totalValue;
    public static volatile SingularAttribute<PurchaseOrderDetail, Item> item;
    public static volatile SingularAttribute<PurchaseOrderDetail, Integer> quantity;
    public static volatile SingularAttribute<PurchaseOrderDetail, Provider> provider;
    public static volatile SingularAttribute<PurchaseOrderDetail, Integer> id;
    public static volatile SingularAttribute<PurchaseOrderDetail, String> state;
    public static volatile SingularAttribute<PurchaseOrderDetail, Float> unitValue;

}