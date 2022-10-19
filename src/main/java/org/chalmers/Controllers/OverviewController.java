package org.chalmers.Controllers;


import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;

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

    public Collection<ITransaction> getLatestTransactions() { //TODO ska hämta data från backend
        List<ITransaction> latestTransactions = new ArrayList<>();
        List<ITransaction> userList = facade.getUser().getCurrentBudget().getTransactions();
        for (int i = 1; i <= 5; i++) {
            if (userList.size()-i >= 0)
                latestTransactions.add(userList.get(userList.size()-i));
            else
                break;
        }
        return latestTransactions;
    }


}