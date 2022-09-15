import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetPostFactoryTests {

    @Test
    public void createBudgetPostNameReturnsCorrectInstance() {
        BudgetPost bp = BudgetPostFactory.createBudgetPost("test");
        assertEquals(bp.getName() + bp.getBudgetCap(), "test0");
    }
}
