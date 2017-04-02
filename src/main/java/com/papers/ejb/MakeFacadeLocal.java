/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.Make;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DDELACRUZ
 */
@Local
public interface MakeFacadeLocal {

    void create(Make make);

    void edit(Make make);

    void remove(Make make);

    Make find(Object id);

    List<Make> findAll();

    List<Make> findRange(int[] range);

    int count();
    
}
