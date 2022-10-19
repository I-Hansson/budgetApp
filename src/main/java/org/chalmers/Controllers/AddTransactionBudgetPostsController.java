package org.chalmers.Controllers;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddTransactionBudgetPostsController {


    ModelFacade facade = ModelFacade.getInstance();
    public AddTransactionBudgetPostsController(){

    }

    public Collection<IBudgetPost> getBudgetPosts (){return facade.budgetPostsfromUser();}




}
