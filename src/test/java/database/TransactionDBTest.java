package database;

import org.chalmers.database.TransactionsDB;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Map;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Written by Oscar Cronvall
 *
 */

class TransactionDBTest {

    TransactionsDB tdb = new TransactionsDB(0);

    @BeforeEach
    @After
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
    }

    @Test
    void assertSetAmount(){
        Double expectedAmount = 500.0;
        tdb.setAmount("202104061247", "Ica Maxi", expectedAmount);
        Map<String, Object> transaction = tdb.getTransaction("Ica Maxi", "202104061247");
        assertEquals(expectedAmount, transaction.get("amount"));
    }

    @Test
    void assertSetName(){
        String expectedName = "Ica Maxi";
        tdb.setName("202104061247", "maxi", expectedName);
        Map<String, Object> transaction = tdb.getTransaction(expectedName, "202104061247");
        assertEquals(expectedName, transaction.get("name"));
    }

    @Test
        void assertSetDescription(){
        String expectedDescription = "Jag handlar nudlar på maxi";
        tdb.setDescription("202104061247", "Ica Maxi", expectedDescription);
        Map<String, Object> transaction = tdb.getTransaction("Ica Maxi", "202104061247");
        assertEquals(expectedDescription, transaction.get("description"));
    }
}
