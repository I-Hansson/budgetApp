import org.chalmers.model.database.BudgetPostsDB;
import org.junit.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPostsDBTest {

    BudgetPostsDB db = new BudgetPostsDB("test");

    private void resetDB(){
        File source = new File("./src/main/database/budgetPosts/template.json");
        File dest = new File("./src/main/database/budgetPosts/test.json");
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
        String newName = "Kylskåp";
        db.openSetters();
            db.setName(newName);
        db.closeSetter();

        assertEquals(newName,db.getName());
    }

    @Test
    public void assertNewCap(){
        resetDB();
        Double newCap = 4567.99;
        db.openSetters();
            db.setCap(newCap);
        db.closeSetter();

        assertEquals(newCap,db.getCap());
    }

    @Test
    public void assertNewTransaction(){
        resetDB();
        Integer transactionsLength = db.getTransactions().size();
        db.openSetters();
            db.addTransaction("test transaction", 100.0, "202210032100");
        db.closeSetter();

        Integer newTransactionLength = db.getTransactions().size();
        assertEquals(transactionsLength+1, newTransactionLength);
    }
}
