import org.chalmers.model.database.BudgetPostsDB;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPostsDBTest {

    BudgetPostsDB db = new BudgetPostsDB("test");

    @Test
    public void assertNewName(){
        String newName = "Kylskåp";
        db.openSetters();
            db.setName(newName);
        db.closeSetter();

        assertEquals(newName,db.getName());
    }

    @Test
    public void assertNewCap(){
        Double newCap = 4567.99;
        db.openSetters();
            db.setCap(newCap);
        db.closeSetter();

        assertEquals(newCap,db.getCap());
    }

    @Test
    public void assertNewTransaction(){
        Integer transactionsLength = db.getTransactions().size();
        db.openSetters();
            db.addTransaction("test transaction", 100.0, "202210032100");
        db.closeSetter();

        Integer newTransactionLength = db.getTransactions().size();
        assertEquals(transactionsLength+1, newTransactionLength);
    }
}
