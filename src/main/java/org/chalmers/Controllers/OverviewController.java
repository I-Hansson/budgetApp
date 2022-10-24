package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;



/**
 * Controller class for the view class OverviewView.
 * @author Jonathan
 */

public class OverviewController{


    ModelFacade facade = ModelFacade.getInstance();

    public void clickedNextMonth(){
        facade.getUser().nextCurrentBudget();
    }

    public void clickedPrevMonth(){
        facade.getUser().previousCurrentBudget();
    }




}