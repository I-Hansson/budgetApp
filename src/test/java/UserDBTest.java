import org.chalmers.model.database.UsersDB;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserDBTest {

    UsersDB db = new UsersDB(0);

    private void resetDB(){
        db.openSetters();
            db.setUserName("Kalle");
            db.setBalance(420);
            db.setNewStandardBalance(42069);
        db.closeSetter();
    }

    @Test
    public void assertNewName(){
        resetDB();
        String newName = "Gilfoyle";
        db.openSetters();
            db.setUserName(newName);
        db.closeSetter();
        try {
            Thread.sleep(1000);
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
            Thread.sleep(1000);
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertEquals(newBalanceStandard,db.getStandardBalance());
    }
}
