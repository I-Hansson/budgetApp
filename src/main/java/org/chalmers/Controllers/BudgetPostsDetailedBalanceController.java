package org.chalmers.Controllers;


import org.chalmers.model.IBudgetPost;

public class BudgetPostsDetailedBalanceController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedBalanceController(){}


    private IBudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();

    public String getRemainingBalance(){
        return String.valueOf((budgetPost.getCurrentBalance()));
    }

    public String getBudgetPostColor(){
        return (budgetPost.getColor());
    }
}
