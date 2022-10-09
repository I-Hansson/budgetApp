package org.chalmers.Controllers;

import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionBudgetPostsController {

    private List<BudgetPost> posts = new ArrayList<BudgetPost>( );


    Budget budget = new Budget(2022,10);
    public AddTransactionBudgetPostsController(){
    }

    public List<BudgetPost> getBudgetPosts (){return budget.getBudgetPosts();}




}
