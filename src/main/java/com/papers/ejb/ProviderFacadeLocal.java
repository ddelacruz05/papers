/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.Provider;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DDELACRUZ
 */
@Local
public interface ProviderFacadeLocal {

    void create(Provider provider);

    void edit(Provider provider);

    void remove(Provider provider);

    Provider find(Object id);

    List<Provider> findAll();

    List<Provider> findRange(int[] range);

    int count();
    
}
