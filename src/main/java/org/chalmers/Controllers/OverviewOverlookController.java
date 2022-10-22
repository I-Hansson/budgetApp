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

    private final ModelFacade facade = ModelFacade.getInstance();
    private final Calendar today = new GregorianCalendar();

    public OverviewOverlookController(){}

    public double getOverlookBalance(){
        return facade.getBudgetCap() - facade.getCurrentBudgetBalance();
    }
    public double getOverlookAverage(){
        if (facade.getCurrentBudgetCalendar().get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            return Math.round(100* (facade.getCurrentBudgetBalance() / today.get(Calendar.DAY_OF_MONTH))) / 100.0;
        }
        return Math.round(100*
                (facade.getCurrentBudgetBalance() / 31))
                / 100.0;
    }

}
