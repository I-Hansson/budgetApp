package org.chalmers.model.database;

import org.chalmers.model.ITransaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * Written by Oscar Cronvall
 *
 */
public class TransactionsDB {
    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;
    private List<DBTransaction> transactionsList;

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
            int year = Integer.parseInt( transObj.get("date").toString().substring(0, 4));
            int  month = Integer.parseInt( transObj.get("date").toString().substring(4,6));
            int day = Integer.parseInt( transObj.get("date").toString().substring(6,8));
            Calendar date = new GregorianCalendar( year, month, day);
            DBTransaction newTrans = new DBTransaction(
                    transObj.get("name").toString(),
                    Double.parseDouble(transObj.get("amount").toString()),
                    transObj.get("description").toString(),
                    date,
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
    public List<ITransaction> getTransactionsListMonth(Integer year, Integer month){
        List<ITransaction> result = new ArrayList<>();
        for(DBTransaction trans: transactionsList){
            Integer readYear = trans.getDate().get(Calendar.YEAR);
            Integer readMonth = trans.getDate().get(Calendar.MONTH);
            System.out.print("Month: "+ readMonth);
            System.out.println(" Year: "+ readYear);
            if(year.equals(readYear) && month.equals(readMonth))
                result.add(trans);
        }
        return result;
    }

    public List<ITransaction> getAllTransactions(){
        List<ITransaction> copy = new ArrayList<>();
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
        newTrans.put("budgetPostName", budgetPostName);
        newTrans.put("amount", amount);
        newTrans.put("description", description.toLowerCase(Locale.ROOT));
        System.out.println(oldDB.toJSONString());
        JSONArray transactions = (JSONArray) getTransactionsJSONObj().get("transactions");
        transactions.add(newTrans);
        oldDB.put("transactions", transactions);

    }

    //TODO make an addTransaction method that takes one arguement of the type Transaction

    /**
     * Call this method so that you can edit the database.
     */
    public void openSetters(){
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
    public void closeSetter(){
        try{
            file.write(oldDB.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void eraseAllTransactions(){
        transactionsList = new ArrayList<>();
        oldDB.put("transactions", new JSONArray());

    }
}
