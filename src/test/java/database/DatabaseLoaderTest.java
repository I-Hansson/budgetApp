package database;

import org.chalmers.database.DatabaseLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


    class DatabaseLoaderTest {

    @Test
    void getUserFromDatabaseReturnsCorrectInstance() {
        assertEquals(0, DatabaseLoader.getUserFromDatabase(0).getUserID());
    }
}
