/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DDELACRUZ
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {

    @PersistenceContext(unitName = "PapersMagPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
}
