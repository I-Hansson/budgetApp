package org.chalmers.Controllers;
import org.chalmers.model.IBudgetPost;

/**
 * @author Jonathan
 */

public class BudgetPostsDetailedLastTransactionsController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedLastTransactionsController(){}

    private IBudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();


}
