package org.chalmers.Controllers;


import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

/**
 * Controller class for the view class BudgetPostDetailedBalance.
 *
 * @author Jonathan
 */

public class BudgetPostsDetailedBalanceController {

    ModelFacade facade = ModelFacade.getInstance();
    private final IBudgetPost budgetPost;

    public BudgetPostsDetailedBalanceController(){
        budgetPost = facade.getSelectedBudgetPost();
    }

    public String getRemainingBalance(){
        return String.valueOf((budgetPost.getCurrentBalance()));
    }

    public String getBudgetPostColor(){
        return (budgetPost.getColor());
    }
}
