import org.chalmers.model.database.UsersDB;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserDBTest {

    UsersDB db = new UsersDB(0);

    private void resetDB(){
        File source = new File("./src/main/database/users/template.json");
        File dest = new File("./src/main/database/users/0.json");
        try{
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void assertNewName(){
        resetDB();
        String newName = "Gilfoyle";
        db.openSetters();
        db.setUserName(newName);
        db.closeSetter();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertEquals(newName,db.getUserName());
    }

    @Test
    public void assertNewBalance(){
        resetDB();
        Double newBalance = 10420.0;
        db.openSetters();
        db.setBalance(newBalance);
        db.closeSetter();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertEquals(newBalance,db.getBalance());
    }

    @Test
    public void assertNewStandardBalance(){
        resetDB();
        Double newBalanceStandard = 10469.0;
        db.openSetters();
        db.setNewStandardBalance(newBalanceStandard);
        db.closeSetter();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertEquals(newBalanceStandard,db.getStandardBalance());
    }

    @Test
    public void assertNoDuplicateBudgetPosts(){
        resetDB();

        int expected = db.getBudgetPosts().size();

        db.openSetters();
        db.addBudgetPost("mat");
        db.addBudgetPost("matvaror");
        db.closeSetter();
        assertEquals(expected, db.getBudgetPosts().size());
    }
}