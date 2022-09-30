package org.chalmers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    private double startBalance;
    private double currentBalance;
    private String name;
    private int id;
    private boolean instantiatd = false;
    private Map<String, BudgetPost> budgetPosts = new HashMap<>();
    private ArrayList<Transaction> recentTransactions = new ArrayList<>();
    //List of investments

    public User(){
        if(!instantiatd) Instantiate();
    }

    //Getters
    public double getCurrentBalance() {
        return currentBalance;
    }
    public double getStartBalance(){
        return currentBalance;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
    public ArrayList getRecentTransactions(){
        return recentTransactions;
    }
    //Methodology


    /**
     * Gives us (the developers) a sample values to work with in development.
     */
    public void Instantiate(){
        setStartBalance(10000);
        currentBalance = 10000;
        name = "Oscar";
        id = 4;
        instantiatd = true;
    }

    /**
     * Sets the new start balance for each month.
     * @param newStartBalance the new starting value for each month.
     */
    public void setStartBalance(double newStartBalance){
        startBalance = newStartBalance;
    }

    /**
     * Update the current balance.
     * @param change the amount that changes, if expense use negative values.
     */
    public void updateBalance(double change){
        currentBalance += change;
    }

    /**
     * Add a NEW budget-post to the users budget planner.
     * @param budgetPost new BudgetPost instance
     */
    public void addBudgetPost(BudgetPost budgetPost){
        if(!budgetPosts.containsKey(name)){
            budgetPosts.put("test", budgetPost);
        } else{
            //TODO Alert user that post already exists
            System.out.println("Post " + name + " already exists");
        }
    }

    public void addTransaction(Transaction transaction) {
        recentTransactions.add(transaction);
        addTransactionToBudgetPost(transaction);

    }

    public ArrayList<BudgetPost> getBudgetPosts() {
        return (ArrayList<BudgetPost>) budgetPosts.values();
    }

    private void addTransactionToBudgetPost(Transaction transaction) {
        budgetPosts.get(transaction.getBudgetPostName()).addTransaction(transaction);
    }

}
