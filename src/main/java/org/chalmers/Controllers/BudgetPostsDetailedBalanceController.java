package org.chalmers.Controllers;


import org.chalmers.model.BudgetPost;

public class BudgetPostsDetailedBalanceController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedBalanceController(){}


    private BudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();

    public String getRemainingBalance(){
        return String.valueOf((budgetPost.getCurrentBalance()));
    }

    public String getBudgetPostColor(){
        return (budgetPost.getColor());
    }
}
