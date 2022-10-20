package org.chalmers.Controllers;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.SelectedBudgetPost;

import java.util.Objects;

/**
 * Controller class for the view class BudgetPostDetailedView.
 *
 * @author Jonathan
 */


public class BudgetPostdetailedViewController {

    public BudgetPostdetailedViewController(){}

    ModelFacade facade = ModelFacade.getInstance();


    public IBudgetPost getCurrentBudgetPost(){return facade.getSelectedBudget().getSelectedBudgetPost();}

    public void setCorrspondingId(String name) {
        for(IBudgetPost bp : facade.budgetPostsfromUser()){
            if(Objects.equals(bp.getName(), name)) {
                  facade.getSelectedBudget().setSelectedBudgetPost(bp);
            }
        }

    }}


