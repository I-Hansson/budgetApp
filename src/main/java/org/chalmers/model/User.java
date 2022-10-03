package org.chalmers.model;

import java.util.ArrayList;
import java.util.List;


public class User {


    private String name;
    private int id;
    private boolean instantiatd = false;
    private List<Budget> budgets = new ArrayList<>();

    //List of investments

    public User(){
        if(!instantiatd) Instantiate();
    }

    //Getters



    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    //Methodology


    /**
     * Gives us (the developers) a sample values to work with in development.
     */
    public void Instantiate(){
        name = "Oscar";
        id = 4;
        instantiatd = true;
    }
}
