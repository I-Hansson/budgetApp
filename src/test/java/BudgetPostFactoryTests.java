import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BudgetPostFactoryTests {

    @Test
    public void createBudgetPostNameReturnsCorrectInstance() {
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test");
        assertEquals("test0", bp.getName() + bp.getBudgetCap());
    }

    @Test
    public void createBudgetPostNameBudgetCapReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100);
        assertEquals( "test100", bp.getName() + bp.getBudgetCap());
    }

    @Test
    public void createBudgetPostNameBudgetCapColorReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100, Color.BLACK);
        assertEquals("test1000", bp.getName() + bp.getBudgetCap() + bp.getColorRGB()[0]);
    }
}
