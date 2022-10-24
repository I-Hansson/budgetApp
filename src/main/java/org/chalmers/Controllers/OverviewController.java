package org.chalmers.Controllers;


import org.chalmers.model.ModelFacade;



/**
 * Controller class for the view class OverviewView.
 * Depends on: ModelFacade.
 * @author Jonathan
 */

public class OverviewController{


    ModelFacade facade = ModelFacade.getInstance();

    /**
     * Changes the month to next month.
     */
    public void clickedNextMonth(){
        facade.getUser().nextCurrentBudget();
    }

    /**
     * Changes the month to previous month.
     */
    public void clickedPrevMonth(){
        facade.getUser().previousCurrentBudget();
    }




}