/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.controller;

import com.papers.ejb.ItemFacadeLocal;
import com.papers.ejb.PurchaseOrderDetailFacadeLocal;
import com.papers.ejb.PurchaseOrderFacadeLocal;
import com.papers.model.Item;
import com.papers.model.PurchaseOrder;
import com.papers.model.PurchaseOrderDetail;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DDELACRUZ
 */
@ManagedBean(name="purchaseOrderDetailController")
@RequestScoped
public class PurchaseOrderDetailController implements Serializable {
    
    @EJB
    private PurchaseOrderDetailFacadeLocal EJBPurchaseOrderDetail;
    
    @EJB
    private PurchaseOrderFacadeLocal EJBPurchaseOrder;
        
    @EJB
    private ItemFacadeLocal EJBItem;
        
    @Inject
    private PurchaseOrderDetail purchaseOrderDetail;    
    private List<PurchaseOrderDetail> purchaseOrderDetails;
    //private Item selectedItem;
    
    @Inject
    private PurchaseOrder purchaseOrder;
    private List<PurchaseOrder> purchaseOrders;
    
    @Inject
    private Item item;    
    private List<Item> items;
    private Item selectedItem;

    public PurchaseOrderDetail getPurchaseOrderDetail() {
        return purchaseOrderDetail;
    }

    public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.purchaseOrderDetail = purchaseOrderDetail;
    }

    public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
    
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

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
    
    @PostConstruct
    public void init(){
        items = EJBItem.findAll();
        Collections.sort(items);
        
        //provider = EJBMake.findAll();
        //Collections.sort(makes);
        //categories = EJBCategory.findAll();
        //Collections.sort(catemakesgories);
        //owners = EJBOwner.findAll();
        //Collections.sort(owners);
    }
    
    public void register(){
        
        try {
            //purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
            //purchaseOrderDetail.setItem(item);
            
            EJBPurchaseOrderDetail.create(purchaseOrderDetail);
            //items = EJBItem.findAll();
            //Collections.sort(items);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró la Orden de Compra correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al registrar Orden de Compra"));
        }
    }
    
    public void addDetail() {
        purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
        purchaseOrderDetail.setItem(item);
        purchaseOrderDetails.add(purchaseOrderDetail);
    }
    
//    public void onRowEdit(RowEditEvent event) {
//        try {
//            EJBItem.edit((Item) event.getObject());
//            FacesContext.getCurrentInstance().addMessage(null, 
//                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se actualizó el articulo correctamente"));
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, 
//                    new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error al actualizar Articulo"));
//        }        
//    }
//     
//    public void onRowCancel(RowEditEvent event) {
//        
//        FacesContext.getCurrentInstance().addMessage(null, 
//                new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Edición cancelada correctamente"));
//        
//    }
}
