package database;

import org.chalmers.database.DatabaseLoader;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseLoaderTest {



    @Test
    public void getUserFromDatabaseReturnsCorrectInstance() {
        assertEquals(0, DatabaseLoader.getUserFromDatabase(0).getUserID());
    }
}
