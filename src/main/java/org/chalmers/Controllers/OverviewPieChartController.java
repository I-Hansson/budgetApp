package org.chalmers.Controllers;

import org.chalmers.model.*;

import java.util.Collection;

/**
 * Controller class for the pie chart on the overview page
 *
 * @author williamfrisk
 */
public class OverviewPieChartController {

    ModelFacade facade = ModelFacade.getInstance();

    public OverviewPieChartController(){}

    public IBudget getBudget() {
        return facade.getCurrentBudget();
    }

    public Collection<IBudgetPost> getBudgetPosts() {
        return facade.getBudgetPosts();
    }
}
