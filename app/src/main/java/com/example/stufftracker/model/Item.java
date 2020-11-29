package com.example.stufftracker.model;

public class Item {
    private String name;
    private int count;

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setCount(int count) {
        if (count > 0) {
            this.count = count;
        }
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }


    public void inc()  {
        count++;
    }

    public void dec() {
        // cannot have negative inventory
        if (count > 0){
            count--;
        }
    }

    public Item(String name, int count) {
        this.count = Math.max(count, 0); // cannot have negative inventory
        this.name = name;
        this.count = count;
    }
}
