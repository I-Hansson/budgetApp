package org.chalmers.model;

import javafx.scene.paint.Color;

import java.util.*;

public class Budget {

    private double startBalance;
    private double currentBalance;
    private int id;

    private List<BudgetPost> budgetPosts = new ArrayList<>();
    private List<Transaction> recentTransactions = new ArrayList<>();

    private int year;
    private int month;
    private Calendar calender = new GregorianCalendar();
    public Budget(){
        this.year = calender.get(Calendar.YEAR);
        this.month = calender.get(Calendar.MONTH);

        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Matvaror",5000,"5, 51, 92"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Transport",1000,"15, 87, 79"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Resturang",800,"166, 212, 227"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Kläder",800,"31, 120, 189"));

    }

    public List<BudgetPost> getBudgetPosts() {
        return this.budgetPosts;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public double getStartBalance(){
        return currentBalance;
    }
    public int getId(){
        return id;
    }
    public List<Transaction> getRecentTransactions(){
        return this.recentTransactions;
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
    public void addTransaction(String name, double amount, BudgetPostID budgetPost, String description){
        this.recentTransactions.add(new Transaction(name, amount,budgetPost,description));
    }
    /**
     * Add a NEW budget-post to the users budget planner.
     * @param name the name of the new post.
     * @param cap the maximum amount intended for this post.
     */
    /*public void addBudgetPost(String name, double cap){
        if(!budgetPosts.containsKey(name)){
            budgetPosts.put("test", new BudgetPost(name,cap));
        } else{
            //TODO Alert user that post already exists
            System.out.println("Post " + name + " already exists");
        }
    }*/
}
