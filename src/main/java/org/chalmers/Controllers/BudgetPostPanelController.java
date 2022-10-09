package org.chalmers.Controllers;


import javafx.scene.paint.Color;
import org.chalmers.OverviewBudgetPost;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.ModelFacade;


import java.util.ArrayList;
import java.util.List;

public class BudgetPostPanelController {
    private List<BudgetPost> budgets = new ArrayList<BudgetPost>( );
    private List<OverviewBudgetPost> budgetPostCards = new ArrayList<OverviewBudgetPost>();
    ModelFacade facade = ModelFacade.getInstance();
    public BudgetPostPanelController (){

        createBudgetPostCards();
    }
    public List<BudgetPost> getBudgetPosts(){
        return this.budgets;
    }
    public List<OverviewBudgetPost> getBudgetPostCards(){
        return this.budgetPostCards;
    }
    public  void createBudgetPostCards(){
        budgetPostCards.clear();
        for (BudgetPost i : facade.budgetPostsfromUser()){
            i.getCurrentBalance();
            double moneyLeft = 0;
            if (i.getBudgetCap()-i.getCurrentBalance() > 0){
                moneyLeft = i.getBudgetCap()-i.getCurrentBalance();
            }
            budgetPostCards.add(new OverviewBudgetPost(i.getId().getName(),String.valueOf(moneyLeft), i.getCurrentBalance()/i.getBudgetCap(), i.getId().getColor(),getComplementColor(i.getId().getColor())));
        }

    }
    public String getComplementColor(String rgb) {
            Color color = Color.web("rgb(" + rgb + ")");
            Color newColor = color.brighter();
        return ""+newColor.getRed()*255+"," + newColor.getGreen()*255 +","+ newColor.getBlue()*255;
    }

}
