package org.chalmers.Controllers;
import org.chalmers.model.IBudgetPost;

/**
 * Controller class for the view class DetailedLastTransactions.
 *
 * @author Jonathan
 */

public class BudgetPostsDetailedLastTransactionsController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedLastTransactionsController(){}

    private IBudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();


}
