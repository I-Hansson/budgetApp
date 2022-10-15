package org.chalmers.Controllers;


import org.chalmers.model.ModelFacade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AddTransactionController{

    ModelFacade facade = ModelFacade.getInstance();



    public AddTransactionController () {

    }


   public void newTransaction(double amount, String name, String description, LocalDate date, String budgetpost){

       String date1 = date.toString().substring(2,4);

        date1 += date.toString().substring(5,7);
       System.out.println(date1);
       System.out.println(budgetpost);
       facade.addTransaction(name, amount,budgetpost,description, date1);
       System.out.println(facade.getCurrentBudgetTransactions());

   }








}
