package org.chalmers.model.database;

import org.chalmers.model.*;

import java.util.*;

/**
 * @author Isac Hansson
 * Create user from transactions and budgetsposts. (UserDB)
 */
public class DatabaseLoader {

    private static UsersDB userDB ;
    private static User user;


    /**
     *
     * @param userID int that decides what json files to load in from.
     * @return the acuall user
     */
    public static User getUserFromDatabase(int userID){
        userDB = new UsersDB(userID);
        user = new User(Integer.parseInt(userDB.getUid()));
        connectDB();
        return user;
    }


    private static void connectDB() {
        fillBudget();
        for(IBudget budget:   user.getBudgets()){
            int budgetDate = budget.getDate().get(Calendar.YEAR) * 100 + budget.getDate().get(Calendar.MONTH);
            for(Map<String,Object> bp : userDB.getBudgetPosts()){
                int bpDate = Integer.parseInt((String) bp.get("dateOfCreation"));
                if (bpDate<= budgetDate){
                    IBudgetPost budgetPost = new BudgetPost(
                            Double.parseDouble(bp.get("cap").toString()),
                            bp.get("name").toString(),
                            bp.get("color").toString());
                    budget.getBudgetPosts().add(budgetPost);
                }
            }
        }
        for (IBudget budget: user.getBudgets()){
            for(ITransaction t : budget.getTransactions()){
                for(IBudgetPost bp: budget.getBudgetPosts()){
                    DBTransaction temp = (DBTransaction) t;
                    System.out.println(t.getBudgetPostName());
                    if(temp.getBudgetPostName().equals(bp.getName())){
                        temp.setBpID(bp.getId());
                        bp.addTransaction(t);
                    }
                }
            }
        }
    }
    private static void fillBudget(){
        HashMap<Integer, List<ITransaction>> map = loadIntTransactions();
        System.out.println(map);
        TransactionsDB transactionDB = new TransactionsDB(Integer.parseInt(userDB.getUid()));
        ITransaction transaction = transactionDB.getAllTransactions().get(0);
        int fmonth = transaction.getDate().get(Calendar.MONTH);
        int fyear = transaction.getDate().get(Calendar.YEAR);

        Calendar today = new GregorianCalendar();
        int lYear = today.get(Calendar.YEAR);
        int lMonth = today.get(Calendar.MONTH);
        Calendar newCalender = new GregorianCalendar(
                transaction.getDate().get(Calendar.YEAR),
                transaction.getDate().get(Calendar.MONTH),
                transaction.getDate().get(Calendar.DAY_OF_MONTH)
        );
        do {
            Budget budget = new Budget(fyear,fmonth);

            if ( map.containsKey(fyear*100 + fmonth)){
                budget.getTransactions().addAll(map.get(fyear*100 + fmonth));
            }
            user.getBudgets().add(budget);


            newCalender.add(Calendar.MONTH,1);
            fmonth = newCalender.get(Calendar.MONTH);
            fyear = newCalender.get(Calendar.YEAR);
        } while (fyear*100 + fmonth <= (lYear*100 + lMonth));

        user.setCurrentBudget(user.getBudgets().get((user.getBudgets().size()-1)));

    }

    private static HashMap<Integer, List<ITransaction>> loadIntTransactions() {

        HashMap<Integer, List<ITransaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(Integer.parseInt(userDB.getUid()));
        for(ITransaction transaction: uDB.getAllTransactions()){
            int year = transaction.getDate().get(Calendar.YEAR);
            int month = transaction.getDate().get(Calendar.MONTH);
            Integer transactionKey = year *100 + month;
            System.out.println("TKEY: " + transactionKey);
            if(map.containsKey(transactionKey)){
                map.get(transactionKey).add(transaction);
            }else{
                List<ITransaction> temp = new ArrayList<>();
                temp.add(transaction);
                map.put(transactionKey,temp);
            }

        }
        return map;
    }



}
