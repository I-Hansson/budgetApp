package org.chalmers.model;

public class BudgetPostID {

    private String name;
    private String color;
    private String id;


    public BudgetPostID(String name, String color, String id) {
        this.name = name;
        this.color = color;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}