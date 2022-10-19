package org.chalmers.Controllers;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionBudgetPostsController {


    ModelFacade facade = ModelFacade.getInstance();
    public AddTransactionBudgetPostsController(){

    }

    public List<IBudgetPost> getBudgetPosts (){return facade.budgetPostsfromUser();}




}
