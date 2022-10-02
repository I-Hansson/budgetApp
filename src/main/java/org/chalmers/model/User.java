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




    /**
     * Add a NEW budget-post to the users budget planner.
     * @param budgetPost new BudgetPost instance
     */
/*
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
*/

}
