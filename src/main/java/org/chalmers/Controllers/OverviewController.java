package org.chalmers.Controllers;


import org.chalmers.OverviewBudgetPost;
import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Controller class for the view class OverviewView.
 *
 * @author Jonathan
 */

public class OverviewController{

    private List<IBudgetPost> budgets = new ArrayList<>();
    private List<OverviewBudgetPost> budgetPostCards = new ArrayList<OverviewBudgetPost>();
    ModelFacade facade = ModelFacade.getInstance();


    public List<IBudgetPost> getBudgetPosts(){
        return this.budgets;
    }
    public List<OverviewBudgetPost> getBudgetPostCards(){
        return this.budgetPostCards;
    }


    public Collection<IBudgetPost> getBudgetPostsfromUser(){
        return facade.getBudgetPosts();
    }


    public OverviewController(){


    }

    public void SwitchToPastTransactions(){


    }


    public void UpdateBudgetPanel (){


    }



    public void clickedNextMonth(){
        facade.getUser().nextCurrentBudget();
    }
    public void clickedPrevMonth(){
        facade.getUser().previousCurrentBudget();
    }

    public Collection<ITransaction> getLatestTransactions() { //TODO ska hämta data från backend
        List<ITransaction> latestTransactions = new ArrayList<>();
        ITransaction[] userArray = {};
        userArray = facade.getUser().getCurrentBudget().getTransactions().toArray(userArray);
        for (int i = 1; i <= 5; i++) {
            if (userArray.length-i >= 0)
                latestTransactions.add(userArray[userArray.length-i]);
            else
                break;
        }
        return latestTransactions;
    }


}