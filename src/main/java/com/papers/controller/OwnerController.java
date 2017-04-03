/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.OwnerFacadeLocal;
import com.papers.model.Owner;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DDELACRUZ
 */
@ManagedBean(name="ownerController")
@RequestScoped
public class OwnerController implements Serializable {
    
    @EJB
    private OwnerFacadeLocal EJBOwner;
    @Inject
    private Owner owner;    
    private List<Owner> owners;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
    
    @PostConstruct
    public void init(){
        owners = EJBOwner.findAll();
        Collections.sort(owners);
    }
    
    public void register(){
        
        try {
            EJBOwner.create(owner);
            owners = EJBOwner.findAll();
            Collections.sort(owners);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró la categoría correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Propietario"));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            EJBOwner.edit((Owner) event.getObject());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó el Propietario correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar Propietario"));
        }        
    }
     
    public void onRowCancel(RowEditEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
        
    }
}
