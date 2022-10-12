package org.chalmers.model.database;

import org.chalmers.model.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Written by Oscar Cronvall
 *
 */
public class TransactionsDB {
    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;
    private List<Transaction> transactionsList;

    public TransactionsDB(int uid){
        connector = new DatabaseConnector("./src/main/database/transactions/"+uid+".json");
        file = null;
        oldDB = null;
        populateTransactionsList();
    }

    private JSONObject getTransactionsJSONObj(){
        return connector.getDbObj();
    }

    private void populateTransactionsList(){
        transactionsList = new ArrayList<>();
        JSONArray resp = (JSONArray) getTransactionsJSONObj().get("transactions");
        for(Object obj: resp){
            JSONObject transObj = (JSONObject) obj;
            Transaction newTrans = new Transaction(
                    transObj.get("name").toString(),
                    Double.parseDouble(transObj.get("amount").toString()),
                    transObj.get("description").toString(),
                    transObj.get("date").toString(),
                    transObj.get("budgetPostName").toString()
            );
            transactionsList.add(newTrans);
        }
    }

    /**
     * This method will return a list of objects of the type Transactions within a specified time frame.
     * Why it only returns within a specified time frame is because this is needed in most frames of the program.
     * @param year the year of the time frame
     * @param month the month of the time frame
     * @return a list of all transactions listed for the specified time frame
     */
    public List<Transaction> getTransactionsListMonth(Integer year, Integer month){
        List<Transaction> result = new ArrayList<>();
        for(Transaction trans: transactionsList){
            Integer readYear = Integer.parseInt(trans.getDateString().substring(0,2));
            Integer readMonth = Integer.parseInt(trans.getDateString().substring(2,4));
            System.out.print("Month: "+ readMonth);
            System.out.println(" Year: "+ readYear);
            if(year.equals(readYear) && month.equals(readMonth))
                result.add(trans);
        }
        return result;
    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> copy = new ArrayList<>();
        System.out.println();
        copy.addAll(transactionsList);
        return copy;
    }

    /**
     *
     * @param name The name of the new transaction E.g. Ica or Coop
     * @param description A more detailed text about the transaction
     * @param amount The cost of the transaction E.g. 12.0
     * @param date The time of the transaction in the format of year,month,day,time E.g. 2210111300 is 13:00 the 11:th of october 2022
     * @param budgetPostName the name of the budget post the transaction is categorized as
     */
    public void addTransaction(String name, String description, Double amount, String date, String budgetPostName){
        JSONObject newTrans = new JSONObject();
        newTrans.put("name", name);
        newTrans.put("date", date);
        newTrans.put("budgetPostName", budgetPostName.toLowerCase(Locale.ROOT));
        newTrans.put("amount", amount);
        newTrans.put("description", description.toLowerCase(Locale.ROOT));
        JSONArray transactions = (JSONArray) getTransactionsJSONObj().get("transactions");
        transactions.add(newTrans);
        openSetters();
        oldDB.put("transactions", transactions);
        closeSetter();
    }

    //TODO make an addTransaction method that takes one arguement of the type Transaction

    /**
     * Call this method so that you can edit the database.
     */
    private void openSetters(){
        try{
            file = new FileWriter(connector.getDbPath());
            oldDB = getTransactionsJSONObj();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Call this method to write and close new edits to the database.
     * To edit again call on the openSetters() method
     */
    private void closeSetter(){
        try{
            file.write(oldDB.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
