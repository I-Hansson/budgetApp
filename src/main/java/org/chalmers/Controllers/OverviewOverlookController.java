package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Controller class for the view class OverlookView.
 *
 * @author Jonathan
 */

public class OverviewOverlookController {

    private ModelFacade facade = ModelFacade.getInstance();
    private Calendar today = new GregorianCalendar();

    public OverviewOverlookController(){}

    public double getOverlookBalance(){
        return facade.getBudgetCap() - facade.getCurrentBalance();
    }
    public double getOverlookAverage(){return facade.getCurrentBalance() / today.get(Calendar.DAY_OF_MONTH);}

}
