package com.papers.model;

import com.papers.model.AttributeType;
import com.papers.model.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-08T12:33:33")
@StaticMetamodel(ItemAttribute.class)
public class ItemAttribute_ { 

    public static volatile SingularAttribute<ItemAttribute, Item> item;
    public static volatile SingularAttribute<ItemAttribute, String> attributeValue;
    public static volatile SingularAttribute<ItemAttribute, AttributeType> attributeType;
    public static volatile SingularAttribute<ItemAttribute, Integer> id;
    public static volatile SingularAttribute<ItemAttribute, String> state;

}