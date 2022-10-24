package org.chalmers.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * This class represents a user. Stores all budgets.
 * Depends on Budget
 *
 * @author Isac Hansson
 * @author williamfrisk
 */
public class User {
    private String name;
    private List<IBudget> budgets = new ArrayList<>();
    private IBudget currentBudget;
    private int id;

    /**
     * Constructs an instance of User.
     * 
     * @param id The desired id for the User.
     */
    public User(int id){
        this.name = "temp";
        this.id = id;
        this.currentBudget = new Budget(2022,9);
    }

    //Getters

    /**
     * Returns the budget for the given date.
     *
     * @param year The year of the budget.
     * @param month The month of the budget.
     * @return The IBudget.
     */
    public IBudget getSpecificbudget(int year, int month) {
        for (IBudget budget : budgets) {
            if (budget.getDate().get(Calendar.YEAR) == year && budget.getDate().get(Calendar.MONTH) == month) {
                return budget;
            }
        }
        return null;
    }

    /**
     * Returns a List of all budgets in the user.
     * @return The list of IBudget.
     */
    public List<IBudget> getBudgets() {
        return budgets;
    }

    /**
     * Returns a list of the budgets in the user that are saveable.
     *
     * @return The list of SaveableBudget.
     */
    public List<SaveableBudget> getSaveableBudgets() {
        List<SaveableBudget> saveableBudgets = new ArrayList<>();

        for(IBudget budget : budgets) {
            if (budget instanceof SaveableBudget) {
                saveableBudgets.add((SaveableBudget) budget);
            }
        }

        return saveableBudgets;
    }

    /**
     * Returns the user's id.
     *
     * @return The user id int.
     */
    public int getUserID(){
        return this.id;
    }

    /**
     * Returns the currently active budget.
     * @return The active IBudget.
     */
    public IBudget getCurrentBudget() {
        return currentBudget;
    }

    /**
     * Returns the name of the user.
     * @return The name String.
     */
    public String getName(){
        return name;
    }

    //Setters

    /**
     * Sets the currently active budget.
     * @param currentBudget The budget to be set.
     */
    public void setCurrentBudget(IBudget currentBudget) {
        this.currentBudget = currentBudget;
    }

    /**
     * Sets the name of the user.
     * @param name The name to be set.
     */
    public void setName(String name){ this.name = name;}
    //Methods

    /**
     * Switches the currently active budget to the next in the collection of budgets.
     */
    public void nextCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        if(index + 1 >= budgets.size()){

        }else {
            this.currentBudget = budgets.get(index+1);
        }

    }

    /**
     * Switches the currently active budget to the previous in the collection of budgets.
     */
    public void previousCurrentBudget(){
        int index = budgets.indexOf(this.currentBudget);
        if (index <= 0){
            index = budgets.size();
        }
        this.currentBudget = budgets.get(index-1);
    }
}
