/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.UserFacadeLocal;
import com.papers.model.User;
import java.io.Serializable;
//import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author DDELACRUZ
 */
@Named
@ViewScoped
public class IndexController implements Serializable{
   
   @EJB
   private UserFacadeLocal userEJB;
   private User user;
   
   @PostConstruct
   public void init(){
       user = new User();
   }   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String beginSession(){
        User vUser;
        String redirect = null;
        try {
            vUser = userEJB.beginSession(user);
            if (vUser!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", vUser);
                redirect = "/protected/main?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Usuario"));
        }
        return redirect;
    }   
}
