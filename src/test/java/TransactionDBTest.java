import org.chalmers.model.Transaction;
import org.chalmers.model.database.TransactionsDB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Written by Oscar Cronvall
 *
 */
public class TransactionDBTest {

    TransactionsDB testDb = new TransactionsDB(0);

    @Before
    public void init(){
        try{
            File srcFile = new File("./src/main/database/transactions/template.json");
            File destFile = new File("./src/main/database/transactions/0.json");
            FileChannel src = new FileInputStream(srcFile).getChannel();
            FileChannel dest = new FileOutputStream(destFile).getChannel();
            dest.transferFrom(src, 0, src.size());
        } catch (IOException e){
            e.printStackTrace();
        }
        /*testDb.addTransaction("TestName",
                "Test Desc",
                420.0, "1912202200",
                "testPost"
        );*/
    }

    @Test
    @Order(1)
    public void assertTransactionsThisMonth(){
        List<Transaction> readTrans = testDb.getTransactionsListMonth(22,10);
        //Should be 2 since the template.json only contains 2 transaction in october 2022
        assertEquals(2,readTrans.size());
    }

    @Test
    @Order(2)
    public void assertReadAllTransactions(){
        List<Transaction> readTrans = testDb.getAllTransactions();
        //Should be 3 since the template.josn only contains 3 transactions
        assertEquals(3,readTrans.size());
    }

   /* @Test
    @Order(3)
    public void assertAddTransaction(){
        List<Transaction> readTrans = testDb.getTransactionsListMonth(19,12);

        assertEquals(1,readTrans.size());
    }*/

}
