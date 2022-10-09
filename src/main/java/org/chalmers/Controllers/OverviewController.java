package org.chalmers.Controllers;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.User;

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


}