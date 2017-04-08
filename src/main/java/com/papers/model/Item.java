/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papers.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DDELACRUZ
 */
@Entity
@Table(name = "bl_items")
public class Item implements Serializable,Comparable<Item>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "make")
    private Make make;
    
    @Column(name = "serial")
    private String serial;
    
    @Column(name = "reference")
    private String reference;
    
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    
    @Column(name = "stock")
    private int stock;
    
    @Column(name = "sale_price")
    private float salePrice;
    
    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;
    
    @Column(name = "state")
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public int compareTo(Item item3){
        String item1 = new String(this.getDescription());
        String item2 = new String(item3.getDescription());
        return item1.compareToIgnoreCase(item2);
    } 
}
