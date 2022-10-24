package model;

import org.chalmers.model.Budget;
import org.chalmers.model.IBudget;
import org.chalmers.model.SaveableBudget;
import org.chalmers.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTest {

    User testUser = new User(1);;
    IBudget testBudget = new Budget(2021, 8);
    IBudget testBudget2 = new Budget(2022, 2);

    @Test
    @Order(2)
    void getSpecificBudgetReturnsCorrectInstance() {
        testUser.getBudgets().add(testBudget);
        assertEquals(testBudget, testUser.getSpecificbudget(2021, 8));
    }

    @Test
    @Order(3)
    void getSaveableBudgetsReturnsCorrectTypes() {
        for (int i = 0; i < testUser.getSaveableBudgets().size(); i++) {
            assertTrue(testUser.getSaveableBudgets().get(i) instanceof SaveableBudget);
        }
    }

    @Test
    @Order(4)
    void getNameReturnsCorrectString() {
        assertEquals("temp", testUser.getName());
    }

    @Test
    @Order(5)
    void getUserIDReturnsCorrectInt() {
        assertEquals(1, testUser.getUserID());
    }

    @Test
    @Order(6)
    void currentBudgetIsMutable() {
        testUser.setCurrentBudget(testBudget);
        assertEquals(testBudget, testUser.getCurrentBudget());
    }

    @Test
    @Order(7)
    void nextCurrentBudgetSwitchesBudget() {
        testUser.getBudgets().clear();
        testUser.getBudgets().add(testBudget);
        testUser.getBudgets().add(testBudget2);
        testUser.setCurrentBudget(testBudget);

        testUser.nextCurrentBudget();
        assertEquals(testBudget2, testUser.getCurrentBudget());
    }

    @Test
    @Order(8)
    void previousCurrentBudgetSwitchesBudget() {
        testUser.getBudgets().clear();
        testUser.getBudgets().add(testBudget);
        testUser.getBudgets().add(testBudget2);
        testUser.setCurrentBudget(testBudget2);

        testUser.previousCurrentBudget();
        assertEquals(testBudget, testUser.getCurrentBudget());
    }
}
