package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BudgetPostDetailedOverLookController {

    private ModelFacade facade = ModelFacade.getInstance();
    private Calendar today = new GregorianCalendar();

    public BudgetPostDetailedOverLookController(){}


    public double getBudgetPostBalance(){
        return facade.getSelectedBudget().getSelectedBudgetPost().getCurrentBalance();
    }

    public double getBudgetPostBudgetCap(){
        return facade.getSelectedBudget().getSelectedBudgetPost().getBudgetCap();
    }

    public double getBudgetPostAverage(){
        return Math.round(100* (getBudgetPostBalance() / today.get(Calendar.DAY_OF_MONTH))) / 100.0;
    }



}