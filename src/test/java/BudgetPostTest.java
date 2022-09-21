import org.chalmers.model.BudgetPost;
import org.chalmers.model.Color;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BudgetPostTest {

    @Test
    public void getColorRGBReturnsCorrectValues(){
        BudgetPost bp = new BudgetPost("test", 100);
        bp.setColor(Color.RED);
        int[] correctRGBValues = new int[]{255, 0, 0};
        assertArrayEquals(correctRGBValues, Color.RED.getRGBValues());
    }
}
