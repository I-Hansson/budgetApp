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


    ModelFacade facade = ModelFacade.getInstance();

    public void clickedNextMonth(){
        facade.getUser().nextCurrentBudget();
    }

    public void clickedPrevMonth(){
        facade.getUser().previousCurrentBudget();
    }




}