
import org.chalmers.model.Color;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void returnsCorrectColor(){
        int[] correctRGBValues = new int[]{255, 0, 0};
        assertArrayEquals(correctRGBValues, Color.RED.getRGBValues());
    }

    @Test
    public void nextReturnsNextColor() {
        assertEquals(Color.BLUE, Color.RED.next());
    }
}