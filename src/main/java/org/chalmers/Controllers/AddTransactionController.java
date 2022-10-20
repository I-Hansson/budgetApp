package org.chalmers.Controllers;


import org.chalmers.model.ModelFacade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Controller class for the view class AddTransactionView.
 *
 * @author Jonathan
 */


public class AddTransactionController{

    ModelFacade facade = ModelFacade.getInstance();



    public AddTransactionController () {

    }


   public void newTransaction(double amount, String name, String description, LocalDate date, String budgetpost){

       facade.addTransaction(name, amount,budgetpost,description, new GregorianCalendar(date.getYear(),date.getMonthValue()-1,date.getDayOfMonth()));
       System.out.println(facade.getCurrentBudgetTransactions());

   }








}
