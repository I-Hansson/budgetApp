package org.chalmers.Controllers;

import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;

import java.util.ArrayList;
import java.util.List;

public class AddTransactionBudgetPostsController {

    private List<BudgetPost> posts = new ArrayList<BudgetPost>( );


    Budget budget = new Budget();
    public AddTransactionBudgetPostsController(){


   /*     BudgetPost post1 = new BudgetPost("Nöje",3000,"White");
        BudgetPost post2 = new BudgetPost("Savings",3000,"White");
        BudgetPost post3 = new BudgetPost("Yaki-Da",3000,"White");
        BudgetPost post4 = new BudgetPost("Push",3000,"White");


        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);*/

    }

    public List<BudgetPost> getBudgetPosts (){return budget.getBudgetPosts();}



}
