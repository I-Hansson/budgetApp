package org.chalmers.Controllers;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.Transaction;

public class OverviewOverlookController {

    ModelFacade facade = ModelFacade.getInstance();

    public OverviewOverlookController(){}

    public double getOverlookBalance(){
        return facade.getCurrentBalance();
    }
    public String getOverlookAverage(){return "N/A";}

}
