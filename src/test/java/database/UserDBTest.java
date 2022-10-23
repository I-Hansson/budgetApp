package database;

import org.chalmers.database.UsersDB;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 * Written by Oscar Cronvall
 *
 */
@TestMethodOrder(OrderAnnotation.class)
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
        String expectedName = "Kalle";
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
}
