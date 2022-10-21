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

    //TODO Får det finnas sånna här metoder i en controller?
    public IBudget getBudget() {
        return facade.getUser().getCurrentBudget();
    }

    public Collection<IBudgetPost> getBudgetPosts() {
        return facade.getBudgetPosts();
    }
}
