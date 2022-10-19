package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a user
 *
 * Depends on Budget
 *
 * @author Isac Hansson
 */
public class User {

    private String name;
    private int id;
    private boolean instantiatd = false;
    private List<IBudget> budgets = new ArrayList<>();
    private IBudget currentBudget;

    public User(){
        if(!instantiatd) Instantiate();
        this.currentBudget = new Budget(2011,2);
    }

    //Getters
    public List<IBudget> getBudgets() {
        return budgets;
    }

    public IBudget getCurrentBudget() {
        return currentBudget;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    //Setters
    public void setCurrentBudget(IBudget currentBudget) {
        this.currentBudget = currentBudget;
    }

    //Methods

    //TODO bättre kommentarer
    /**
     * Switches currentBudget
     */
    public void nextCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        if(index + 1 >= budgets.size()){
            index = -1;
        }
        this.currentBudget = budgets.get(index+1);
    }

    /**
     * Switches currentBudget
     */
    public void previousCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        System.out.println(index);
        if (index <= 0){
            index = budgets.size();
        }
        this.currentBudget = budgets.get(index-1);
    }


    /**
     * Gives us (the developers) a sample values to work with in development.
     */
    public void Instantiate(){
        name = "Oscar";
        id = 4;
        instantiatd = true;
    }
}
