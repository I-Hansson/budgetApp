package org.chalmers.Controllers;


import org.chalmers.model.ModelFacade;

import java.time.LocalDate;


public class AddTransactionController{

    ModelFacade facade = ModelFacade.getInstance();



    public AddTransactionController () {

    }


   public void newTransaction(double amount, String name, String description, LocalDate date, String budgetpost){

       System.out.println(budgetpost);
    facade.addTransaction(name, amount,budgetpost,description);
       System.out.println(facade.getCurrentBudgetTransactions());

   }








}
