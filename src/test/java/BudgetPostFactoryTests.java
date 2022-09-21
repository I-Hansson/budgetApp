import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.Color;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPostFactoryTests {

    @Test
    public void createBudgetPostNameReturnsCorrectInstance() {
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test");
        assertEquals(bp.getName() + bp.getBudgetCap(), "test0");
    }

    @Test
    public void createBudgetPostNameBudgetCapReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100);
        assertEquals(bp.getName() + bp.getBudgetCap(), "test100");
    }

    @Test
    public void createBudgetPostNameBudgetCapColorReturnsCorrectInstance(){
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test", 100, Color.BLACK);
        assertEquals(bp.getName() + bp.getBudgetCap() + bp.getColorRGB()[0], "test1000");
    }
}
