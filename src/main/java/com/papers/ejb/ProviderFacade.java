/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.Provider;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DDELACRUZ
 */
@Stateless
public class ProviderFacade extends AbstractFacade<Provider> implements ProviderFacadeLocal {

    @PersistenceContext(unitName = "PapersMagPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProviderFacade() {
        super(Provider.class);
    }
    
}
