package org.chalmers.Controllers;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.Transaction;

import java.util.Collection;
import java.util.List;

public class BudgetPostsDetailedLastTransactionsController {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    public BudgetPostsDetailedLastTransactionsController(){}

    private BudgetPost budgetPost = budgetPostdetailedViewController.getCurrentBudgetPost();


}
