package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;

/**
 * Controller class for the view class OverlookView.
 *
 * @author Jonathan
 */

public class OverviewOverlookController {

    ModelFacade facade = ModelFacade.getInstance();

    public OverviewOverlookController(){}

    public double getOverlookBalance(){
        return facade.getBudgetCap() - facade.getCurrentBalance();
    }
    public String getOverlookAverage(){return "N/A";}

}
