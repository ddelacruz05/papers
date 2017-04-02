/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.MakeFacadeLocal;
import com.papers.model.Make;
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
@ManagedBean(name="makeController")
@RequestScoped
public class MakeController implements Serializable {
    
    @EJB
    private MakeFacadeLocal EJBMake;
    @Inject
    private Make make;    
    private List<Make> makes;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public List<Make> getMakes() {
        return makes;
    }

    public void setMakes(List<Make> makes) {
        this.makes = makes;
    }
    
    @PostConstruct
    public void init(){
        makes = EJBMake.findAll();
        Collections.sort(makes);
    }
    
    public void register(){
        
        try {
            EJBMake.create(make);
            makes = EJBMake.findAll();
            Collections.sort(makes);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró la marca correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Marca"));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            EJBMake.edit((Make) event.getObject());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó la marca correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar Marca"));
        }        
    }
     
    public void onRowCancel(RowEditEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
        
    }
}
