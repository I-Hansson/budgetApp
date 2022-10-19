package org.chalmers.Controllers;
import org.chalmers.model.IBudgetPost;

public class BudgetPostsDetailedLastTransactionsController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedLastTransactionsController(){}

    private IBudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();


}
