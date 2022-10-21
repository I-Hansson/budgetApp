import org.chalmers.model.Transaction;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionTest {

    Transaction testTransaction;
    @Test
    @Order(1)
    public void init() {
    }
}
