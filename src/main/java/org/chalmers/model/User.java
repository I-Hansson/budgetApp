package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class User {


    private String name;
    private int id;
    private boolean instantiatd = false;
    private List<Budget> budgets = new ArrayList<>();
    private Budget currentBudget;


    //List of investments

    public List<Budget> getBudgets() {
        return budgets;
    }

    public User(){
        if(!instantiatd) Instantiate();



        this.currentBudget = new Budget(2011,2);

    }
    //Getters


    public void setCurrentBudget(Budget currentBudget) {
        this.currentBudget = currentBudget;
    }

    public Budget getCurrentBudget() {
        return currentBudget;
    }

    public void nextCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        if(index + 1 >= budgets.size()){
            index = -1;
        }
        this.currentBudget = budgets.get(index+1);
    }
    public void previousCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        System.out.println(index);
        if (index <= 0){
            index = budgets.size();
        }
        this.currentBudget = budgets.get(index-1);
    }

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
