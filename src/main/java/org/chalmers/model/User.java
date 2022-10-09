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

    public User(){
        if(!instantiatd) Instantiate();

        this.budgets.add(new Budget(2022,10));
        this.budgets.add(new Budget(2022,11));
        this.budgets.add(new Budget(2022,12));
        this.budgets.add(new Budget(2023,1));
        this.budgets.add(new Budget(2023,2));
        this.budgets.add(new Budget(2023,3));
        budgets.get(1).getBudgetPosts().get(0).setCurrentBalance(1000);

        this.currentBudget = budgets.get(0);

    }
    //Getters


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
