/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.model.User;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author DDELACRUZ
 */
@Named("templateController")
@ViewScoped
public class TemplateController implements Serializable{
    
    public void checkSession(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            User user = (User) context.getExternalContext().getSessionMap().get("user");
            if (user == null){
                context.getExternalContext().redirect("./../permissions.jsf");
            }
        } catch (Exception e) {
            
        }
    }
    
    public void closeSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
