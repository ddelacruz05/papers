/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.AttributeType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DDELACRUZ
 */
@Local
public interface AttributeTypeFacadeLocal {

    void create(AttributeType attributeType);

    void edit(AttributeType attributeType);

    void remove(AttributeType attributeType);

    AttributeType find(Object id);

    List<AttributeType> findAll();

    List<AttributeType> findRange(int[] range);

    int count();
    
}
