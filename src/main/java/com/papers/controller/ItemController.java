/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.CategoryFacadeLocal;
import com.papers.ejb.ItemFacadeLocal;
import com.papers.ejb.MakeFacadeLocal;
import com.papers.ejb.OwnerFacadeLocal;
import com.papers.model.Category;
import com.papers.model.Item;
import com.papers.model.Make;
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
@ManagedBean(name="itemController")
@RequestScoped
public class ItemController implements Serializable {
    
    @EJB
    private ItemFacadeLocal EJBItem;
    
    @EJB
    private MakeFacadeLocal EJBMake;
    
    @EJB
    private CategoryFacadeLocal EJBCategory;
    
    @EJB
    private OwnerFacadeLocal EJBOwner;
    
    @Inject
    private Item item;    
    private List<Item> items;
    private Item selectedItem;
    
    @Inject
    private Make make;
    private List<Make> makes;
    
    @Inject
    private Category category;
    private List<Category> categories;
    
    @Inject
    private Owner owner;    
    private List<Owner> owners;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
    
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
        items = EJBItem.findAll();
        Collections.sort(items);
        
        makes = EJBMake.findAll();
        Collections.sort(makes);
        categories = EJBCategory.findAll();
        Collections.sort(categories);
        owners = EJBOwner.findAll();
        Collections.sort(owners);
    }
    
    public void register(){
        
        try {
            item.setMake(make);
            item.setCategory(category);
            item.setOwner(owner);
            
            EJBItem.create(item);
            items = EJBItem.findAll();
            Collections.sort(items);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró el articulo correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Articulo"));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            EJBItem.edit((Item) event.getObject());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó el articulo correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar Articulo"));
        }        
    }
     
    public void onRowCancel(RowEditEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
        
    }
}
