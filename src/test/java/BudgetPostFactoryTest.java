import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BudgetPostFactoryTest {

    @Test
    public void createBudgetPostNameReturnsCorrectInstance() {
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test");
        assertEquals("test0.0", bp.getId().getName() + bp.getBudgetCap());
    }

    @Test
    public void createBudgetPostNameBudgetCapReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100);
        assertEquals( "test100.0", bp.getId().getName() + bp.getBudgetCap());
    }

    /**@Test
    public void createBudgetPostNameBudgetCapColorReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100, Color.BLACK);
        assertEquals("test100.00x000000ff", bp.getName() + bp.getBudgetCap() + bp.getColor().toString());
    }*/
}