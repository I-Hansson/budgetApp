package org.chalmers.Controllers;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OverviewController{
    ModelFacade facade = ModelFacade.getInstance();
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

    public Collection<Transaction> getLatestTransactions() { //TODO ska hämta data från backend
        user.getCurrentBudget().addTransaction(new Transaction("test", 100,
                new BudgetPostID("test", "0, 0, 0", "lol"), " "));

        List<Transaction> latestTransactions = new ArrayList<>();
        List<Transaction> userList = user.getCurrentBudget().getRecentTransactions();

        for (int i = 1; i <= 5; i++) {
            if (userList.size()-i >= 0)
                latestTransactions.add(userList.get(userList.size()-i));
            else
                break;
        }
        return latestTransactions;
    }


}