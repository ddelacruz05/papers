/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.AttributeTypeFacadeLocal;
import com.papers.model.AttributeType;
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
@ManagedBean(name="attributeTypeController")
@RequestScoped
public class AttributeTypeController implements Serializable {
    
    @EJB
    private AttributeTypeFacadeLocal EJBAttributeType;
    @Inject
    private AttributeType attributeType;    
    private List<AttributeType> attributeTypes;

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public List<AttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(List<AttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }
    
    @PostConstruct
    public void init(){
        attributeTypes = EJBAttributeType.findAll();
        Collections.sort(attributeTypes);
    }
    
    public void register(){
        
        try {
            EJBAttributeType.create(attributeType);
            attributeTypes = EJBAttributeType.findAll();
            Collections.sort(attributeTypes);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró el tipo de atributo correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar tipo de atributo"));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            EJBAttributeType.edit((AttributeType) event.getObject());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó el tipo de atributo correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar tipo de atributo"));
        }        
    }
     
    public void onRowCancel(RowEditEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
        
    }
}
