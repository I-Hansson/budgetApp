package org.chalmers.Controllers;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.SelectedBudgetPost;

import java.util.Objects;

public class BudgetPostdetailedViewController {

    public BudgetPostdetailedViewController(){}

    ModelFacade facade = ModelFacade.getInstance();


    public BudgetPost getCurrentBudgetPost(){return facade.getSelectedBudget().getSelectedBudgetPost();}

    public void setCorrspondingId(String name) {
        for(BudgetPost bp : facade.budgetPostsfromUser()){
            if(Objects.equals(bp.getName(), name)) {
                  facade.getSelectedBudget().setSelectedBudgetPost(bp);
            }
        }

    }}


