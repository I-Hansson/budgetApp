package org.chalmers.model;

import java.util.HashMap;
import java.util.Map;

public class User {

    private double startBalance;
    private double currentBalance;
    private String name;
    private int id;
    private boolean instantiatd = false;
    private Map<String, BudgetPost> budgetPosts = new HashMap<>();
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
     * @param name the name of the new post.
     * @param cap the maximum amount intended for this post.
     */
    public void addBudgetPost(String name, double cap){
        if(!budgetPosts.containsKey(name)){
            budgetPosts.put("test", new BudgetPost(name,cap));
        } else{
            //TODO Alert user that post already exists
            System.out.println("Post " + name + " already exists");
        }
    }
}
