import org.chalmers.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    User testUser;

    @Order(1)
    public void init() {
        testUser = new User();
    }
}