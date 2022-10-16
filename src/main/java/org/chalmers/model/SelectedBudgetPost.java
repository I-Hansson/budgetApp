package org.chalmers.model;

// TODO Får jag göra så här ? Kommer antagligen behövs vid de linjäragraferna också

public class SelectedBudgetPost {

    private  BudgetPost selectdBudgetPost;

    public SelectedBudgetPost(BudgetPost selcetedBudgetPost){
        this.selectdBudgetPost = selcetedBudgetPost;
    }

    public void setSelectedBudgetPost(BudgetPost newSelectedBudgetPost){this.selectdBudgetPost = newSelectedBudgetPost;}

    public BudgetPost getSelectedBudgetPost(){return selectdBudgetPost;}

}
