/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.OptionFacadeLocal;
import com.papers.model.Option;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author DDELACRUZ
 */
@Named("optionController")
@SessionScoped
public class OptionController implements Serializable{
    
    @EJB
    private OptionFacadeLocal EJBOption;
    private List<Option> options;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        this.listOptions();
        model = new DefaultMenuModel();
        this.setPermissions();
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    public void listOptions(){
        
        try {
            options = EJBOption.findAll();
        } catch (Exception e) {
        }
    }
    
    public void setPermissions(){
        for(Option option: options){
            if(option.getTopOption()==null){
                DefaultSubMenu subMenu = new DefaultSubMenu(option.getName());
                for(Option op: options){
                    Option subOption = op.getTopOption();
                    if (subOption!=null){
                        if (subOption.getId()==option.getId()){
                            DefaultMenuItem item = new DefaultMenuItem(op.getName());
                            item.setUrl(op.getPage());
                            subMenu.addElement(item);
                        }
                    }
                }
                model.addElement(subMenu);
            }
        }
    }
}
