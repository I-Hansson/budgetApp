package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;
public class OverviewOverlookController {

    ModelFacade facade = ModelFacade.getInstance();

    public OverviewOverlookController(){}

    public double getOverlookBalance(){
        return facade.getCurrentBalance();
    }
    public String getOverlookAverage(){return "N/A";}

}
