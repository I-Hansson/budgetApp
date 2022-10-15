import org.chalmers.model.database.UsersDB;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Written by Oscar Cronvall
 * Used for testing the methods of the UsersDB class
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDBTest {

    UsersDB db = new UsersDB(0);

    @Before
    public void init(){
        try{
            File srcFile = new File("./src/main/database/users/template.json");
            File destFile = new File("./src/main/database/users/0.json");
            FileChannel src = new FileInputStream(srcFile).getChannel();
            FileChannel dest = new FileOutputStream(destFile).getChannel();
            dest.transferFrom(src, 0, src.size());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void assertGetUserName(){
        String expectedName = "oscar";
        assertEquals(expectedName, db.getUserName());
    }

    @Test
    @Order(2)
    public void assertGetBalance(){
        Double expectedBalance = 1000.0;
        assertEquals(expectedBalance, db.getBalance());
    }

    @Test
    @Order(3)
    public void assertGetUid(){
        String expectedID = "0";
        assertEquals(expectedID, db.getUid());
    }

    @Test
    @Order(4)
    public void getStandardBalance(){
        Double exptectedBal = 10000.0;
        assertEquals(exptectedBal, db.getStandardBalance());
    }

    @Test
    @Order(5)
    public void getBudgetPosts(){
        int expectedCount = 4;
        String expectedName = "alkohol";
        Double expectedCap = 5000.0;

        List<Map<String,Object>> bps = db.getBudgetPosts();

        //assert right amount
        assertEquals(expectedCount, bps.size());

        //assert object 3 (index 2) has the name alkohol
        assertEquals(expectedName,bps.get(2).get("name"));

        //assert object 4 (index 3) has the cap of 5000
        assertEquals(expectedCap, bps.get(3).get("cap"));
    }

    @Test
    @Order(6)
    public void addBudgetPostTest(){
        int expectedCount = 5;
        String expectedName = "Clothes";
        Double expectedCap = 1500.0;

        db.addBudgetPost(expectedName,expectedCap,"25,25,25", "2210");

        List<Map<String,Object>> bps = db.getBudgetPosts();
        assertEquals(expectedCount, bps.size());
        assertEquals(expectedName,bps.get(4).get("name"));
        assertEquals(expectedCap,bps.get(4).get("cap"));
    }

    @Test
    @Order(7)
    public void removeBudgetPostTest(){
        int expectedCount = 3;
        String expectedName = "alkohol";
        Double expectedCap = 2500.0;
        //todo
        db.removeBudgetPost("tobak","2210");
        List<Map<String,Object>> list = db.getBudgetPosts();
        assertEquals(expectedCount,list.size());
        assertEquals(expectedName, list.get(list.size()-1).get("name"));
        assertEquals(expectedCap, list.get(list.size()-1).get("cap"));
    }

}
