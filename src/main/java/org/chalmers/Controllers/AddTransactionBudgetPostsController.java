package org.chalmers.Controllers;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.Collection;


/**
 * Controller class for the view class AddTransactionBudgetPostView.
 *
 * @author Jonathan
 *
 *
 */

public class AddTransactionBudgetPostsController {


    ModelFacade facade = ModelFacade.getInstance();
    public AddTransactionBudgetPostsController(){

    }

    public Collection<IBudgetPost> getBudgetPosts (){return facade.getBudgetPosts();}




}
