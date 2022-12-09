package test_database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.entities.FriendsList;
import server.frameworks_and_drivers.database.Database;

import java.io.FileWriter;
import java.io.IOException;

public class DatabaseTest
{
    @Test
    public void testReturnValue1()
    {
        try {
            new FileWriter("testuser.csv", false).close();
            new FileWriter("testuser.csv", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Database database = new Database("testuser.csv", "testchat.csv");
        Assertions.assertEquals(0, database.returnNewUserUid());
        Assertions.assertEquals(1, database.returnNewUserUid());
    }
    @Test
    public void testReturnValue2()
    {
        try {
            new FileWriter("testuser.csv", false).close();
            new FileWriter("testuser.csv", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Database database = new Database("testuser.csv", "testchat.csv");
        Assertions.assertEquals(0, database.returnNewChatUid());
        Assertions.assertEquals(1, database.returnNewChatUid());
        Assertions.assertEquals(0, database.returnNewMsgUid(0));
        Assertions.assertEquals(1, database.returnNewMsgUid(0));
    }

    @Test
    public void testAddUser()
    {
        try {
            new FileWriter("testuser.csv", false).close();
            new FileWriter("testuser.csv", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Database database = new Database("testuser.csv", "testchat.csv");
        database.newUser(0, "kevin", "", "", "", 4444);
        Assertions.assertEquals(0, Integer.parseInt(database.readUser(0)[0]));
        Assertions.assertEquals("kevin", database.readUser(0)[1]);
    }
}
