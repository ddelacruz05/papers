/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.Option;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DDELACRUZ
 */
@Local
public interface OptionFacadeLocal {

    void create(Option option);

    void edit(Option option);

    void remove(Option option);

    Option find(Object id);

    List<Option> findAll();

    List<Option> findRange(int[] range);

    int count();
    
}
