package org.chalmers.Controllers;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.Objects;

/**
 * Controller class for the view class BudgetPostDetailedView.
 * Depends on: ModelFacade.
 * @author Jonathan
 */


public class BudgetPostdetailedViewController {

    public BudgetPostdetailedViewController(){}

    ModelFacade facade = ModelFacade.getInstance();

    /**
     * Checks which budget post that has been selected.
     * @param name Corresponding budget post name.
     */

    public void setCorrspondingId(String name) {
        for(IBudgetPost bp : facade.getBudgetPosts()){
            if(Objects.equals(bp.getName(), name)) {
                  facade.setSelectedBudgetPost(bp);
            }
        }

    }}


