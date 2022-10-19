package org.chalmers.Controllers;

import org.chalmers.model.BudgetPost;

public class BudgetPostsDetailedLastTransactionsController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedLastTransactionsController(){}

    private BudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();


}
