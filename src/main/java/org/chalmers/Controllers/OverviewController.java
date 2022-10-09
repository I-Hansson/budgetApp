package org.chalmers.Controllers;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chalmers.model.User;

public class OverviewController{

    User user = new User();
    public OverviewController(){


    }

    public void SwitchToPastTransactions(){


    }


    public void UpdateBudgetPanel (){


    }

    public User getUser() {
        return user;
    }

    public void clickedNextMonth(){
        user.nextCurrentBudget();
    }
    public void clickedPrevMonth(){
        user.previousCurrentBudget();
    }


}