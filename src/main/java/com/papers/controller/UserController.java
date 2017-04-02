/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.UserFacadeLocal;
import com.papers.model.User;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DDELACRUZ
 */
@Named("userController")
@ViewScoped
public class UserController implements Serializable{
   
   @EJB
   private UserFacadeLocal userEJB;
   
   @Inject
   private User user;
   
   @PostConstruct
   public void init(){
       //user = new User();
   }   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void register(){
        Date systemDate = new Date();
        try {
            this.user.setRegisterDate(systemDate);
            this.user.setUpdateDate(systemDate);
            this.user.setState("A");
            userEJB.create(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró el Usuario correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Usuario"));
        }
    
    }
   
}
