package test_database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.entities.FriendsList;
import server.frameworks_and_drivers.database.Database;

public class DatabaseTest
{
    @Test
    public void testViewFriendsEmptyList()
    {
        Database database = new Database("testuser.csv", "testchat.csv");
    }
}
