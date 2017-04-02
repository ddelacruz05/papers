/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.CategoryFacadeLocal;
import com.papers.model.Category;
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
@ManagedBean(name="categoryController")
@RequestScoped
public class CategoryController implements Serializable {
    
    @EJB
    private CategoryFacadeLocal EJBCategory;
    @Inject
    private Category category;    
    private List<Category> categories;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    @PostConstruct
    public void init(){
        categories = EJBCategory.findAll();
        Collections.sort(categories);
    }
    
    public void register(){
        
        try {
            EJBCategory.create(category);
            categories = EJBCategory.findAll();
            Collections.sort(categories);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró la categoría correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Categoría"));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            EJBCategory.edit((Category) event.getObject());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó la categoría correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar Categoría"));
        }        
    }
     
    public void onRowCancel(RowEditEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
        
    }
}
