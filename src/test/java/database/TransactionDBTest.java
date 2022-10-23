package database;

import org.chalmers.database.TransactionsDB;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Written by Oscar Cronvall
 *
 */

public class TransactionDBTest {

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
    public void assertSetAmount(){
        Double expectedAmount = 500.0;
        tdb.setAmount("202104061247", "maxi", expectedAmount);
        Map<String, Object> transaction = tdb.getTransaction("maxi", "202104061247");
        assertEquals(expectedAmount, transaction.get("amount"));
    }

    @Test
    public void assertSetName(){
        String expectedName = "Ica Maxi";
        tdb.setName("202104061247", "maxi", expectedName);
        Map<String, Object> transaction = tdb.getTransaction(expectedName, "202104061247");
        assertEquals(expectedName, transaction.get("name"));
    }

    @Test
    public void assertSetDescription(){
        String expectedDescription = "Jag handlar nudlar på maxi";
        tdb.setDescription("202104061247", "maxi", expectedDescription);
        Map<String, Object> transaction = tdb.getTransaction("maxi", "202104061247");
        assertEquals(expectedDescription, transaction.get("description"));
    }
}
