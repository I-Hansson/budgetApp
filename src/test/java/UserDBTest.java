import org.chalmers.model.database.UsersDB;
import org.junit.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserDBTest {

    UsersDB db = new UsersDB(0);

    private void resetDB(){
        File source = new File("./src/main/database/users/template.json");
        File dest = new File("./src/main/database/users/0.json");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }catch (IOException e ){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
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
    public void assertNotNewBudgetPost(){
        resetDB();
        Integer startLength = db.getBudgetPosts().size();
        db.openSetters();
            db.addBudgetPost("name");
            db.addBudgetPost("bostad");
            db.addBudgetPost("telefon");
        db.closeSetter();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //Plus one since telefon isn't already a budgetPost.
        assertEquals(startLength+1, db.getBudgetPosts().size());
    }
}
