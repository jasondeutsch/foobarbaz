package com.example.stufftracker.model;

import com.example.stufftracker.model.Inventory;

public class User {
    private String userName;
    private String password;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public User(String userName, String password) {
        // TODO password requirements
        // TODO username requirements
        this.userName = userName;
        // TODO hash password
        this.password = password;
        this.inventory = new Inventory();
    }

    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }
}
