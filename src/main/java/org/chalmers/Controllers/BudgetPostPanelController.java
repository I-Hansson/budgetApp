package org.chalmers.Controllers;


import javafx.scene.paint.Color;
import org.chalmers.OverviewBudgetPost;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan
 */

public class BudgetPostPanelController {
    private List<IBudgetPost> budgets = new ArrayList<>();
    private List<OverviewBudgetPost> budgetPostCards = new ArrayList<OverviewBudgetPost>();
    ModelFacade facade = ModelFacade.getInstance();
    public BudgetPostPanelController (){

        createBudgetPostCards();
    }
    public List<IBudgetPost> getBudgetPosts(){
        return this.budgets;
    }
    public List<OverviewBudgetPost> getBudgetPostCards(){
        return this.budgetPostCards;
    }

    // TODO too much functionality

    public  void createBudgetPostCards(){
        budgetPostCards.clear();
        for (IBudgetPost i : facade.budgetPostsfromUser()){
            i.getCurrentBalance();
            double moneyLeft = 0;
            if (i.getBudgetCap()-i.getCurrentBalance() > 0){
                moneyLeft = i.getBudgetCap()-i.getCurrentBalance();
            }
            budgetPostCards.add(new OverviewBudgetPost(i.getName(),String.valueOf(moneyLeft), i.getCurrentBalance()/i.getBudgetCap(), i.getColor(),getComplementColor(i.getColor())));
        }

    }
    public String getComplementColor(String rgb) {
        Color color = Color.web("rgb(" + rgb + ")");
        Color newColor = color.brighter();
        return ""+newColor.getRed()*255+"," + newColor.getGreen()*255 +","+ newColor.getBlue()*255;
    }

}
