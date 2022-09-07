package org.chalmers.model;

public class BudgetPost {

    private String name;
    //TODO give Icon attribute
    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;
    //TODO list of all transactions belonging to this budgetpost

    public BudgetPost(String name, double budgetCap){
        this.name = name;
        this.budgetCap = budgetCap;
        this.currentBalance = 0;
        //TODO Implement icon logic here aswell.
    }

    /**
     * Update the name of this budget post.
     * @param newName the new name.
     */
    public void changeName(String newName){
        this.name = newName;
    }

    /**
     * Edits the budget cap for this post.
     * Make sure that this change doesn't surpass the users total balance.
     * @param newCap The new cap for this post.
     */
    public void changeBudgetCap(double newCap){
        this.budgetCap = newCap;
    }


}
