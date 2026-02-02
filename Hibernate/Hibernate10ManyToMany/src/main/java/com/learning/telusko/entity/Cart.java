package com.learning.telusko.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_ID;

    private Integer cart_Total;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Item> items;

    public Cart(){
        System.out.println("No param constructor of Cart class");
    }

    public Cart(Integer cart_Total, Set<Item> items) {
        this.cart_Total = cart_Total;
        this.items = items;
    }

    public Integer getCart_ID() {
        return cart_ID;
    }


    public Integer getCart_Total() {
        return cart_Total;
    }

    public void setCart_Total(Integer cart_Total) {
        this.cart_Total = cart_Total;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_ID=" + cart_ID +
                ", cart_Total=" + cart_Total +
                ", items=" + items +
                '}';
    }
}
