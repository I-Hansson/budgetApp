package org.chalmers.Controllers;

import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionBudgetPostsController {


    ModelFacade facade = ModelFacade.getInstance();
    public AddTransactionBudgetPostsController(){

    }

    public List<BudgetPost> getBudgetPosts (){return facade.budgetPostsfromUser();}




}
