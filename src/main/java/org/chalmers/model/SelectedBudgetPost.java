package org.chalmers.model;

// TODO Får jag göra så här ? Kommer antagligen behövs vid de linjäragraferna också

public class SelectedBudgetPost {

    private IBudgetPost selectdBudgetPost;

    public SelectedBudgetPost(IBudgetPost selectedBudgetPost){
        this.selectdBudgetPost = selectedBudgetPost;
    }

    public void setSelectedBudgetPost(IBudgetPost newSelectedBudgetPost){this.selectdBudgetPost = newSelectedBudgetPost;}

    public IBudgetPost getSelectedBudgetPost(){return selectdBudgetPost;}

}
