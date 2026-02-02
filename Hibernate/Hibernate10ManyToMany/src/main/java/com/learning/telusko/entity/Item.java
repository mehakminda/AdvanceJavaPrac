package com.learning.telusko.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Item {

    @Id
    private Integer itemID;

    private String itemName;

    private Double itemPrice;

    public Item(){
        System.out.println("No param constructor of Item class");
    }

    public Item(Integer itemID, String itemName, Double itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName=" + itemName +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
