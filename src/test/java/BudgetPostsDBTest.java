import org.chalmers.model.database.BudgetPostsDB;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPostsDBTest {

    @Test
    public void assertNewName(){
        BudgetPostsDB db = new BudgetPostsDB("test");
        String oldName = db.getName();
        String newName = "Chin Yang";
        db.openSetters();
        db.setName(newName);
        db.closeSetter();
        assertEquals(newName, db.getName());
    }
}
