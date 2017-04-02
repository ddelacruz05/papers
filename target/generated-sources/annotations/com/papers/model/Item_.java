package com.papers.model;

import com.papers.model.Category;
import com.papers.model.Make;
import com.papers.model.Owner;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-01T22:00:18")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> reference;
    public static volatile SingularAttribute<Item, Owner> owner;
    public static volatile SingularAttribute<Item, String> serial;
    public static volatile SingularAttribute<Item, Float> salePrice;
    public static volatile SingularAttribute<Item, String> description;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, String> state;
    public static volatile SingularAttribute<Item, Category> category;
    public static volatile SingularAttribute<Item, Integer> stock;
    public static volatile SingularAttribute<Item, Make> make;

}