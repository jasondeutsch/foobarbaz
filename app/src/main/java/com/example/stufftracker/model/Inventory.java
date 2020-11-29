package com.example.stufftracker.model;


import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory;


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(String name, int count) {
        inventory.add(new Item(name, count));
    }

    public Inventory() {
        inventory = new ArrayList<Item>();
    }
}
