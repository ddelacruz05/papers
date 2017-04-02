/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.ejb;

import com.papers.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DDELACRUZ
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "PapersMagPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public User beginSession(User pUser){
        
        User user = null;
        String sentence;
        try {
            sentence = "FROM User u WHERE u.user = ? AND u.password = ?";
            Query query = em.createQuery(sentence);
            query.setParameter(1, pUser.getUser());
            query.setParameter(2, pUser.getPassword());
            List<User> listUsers = query.getResultList();
            if(!listUsers.isEmpty()){
                user = listUsers.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
}
