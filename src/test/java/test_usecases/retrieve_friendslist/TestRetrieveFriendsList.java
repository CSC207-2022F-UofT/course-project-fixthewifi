package test_usecases.retrieve_friendslist;
import server.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.entities.UserFactory;
import server.frameworks_and_drivers.Constants;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInputData;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInteractor;

import java.util.ArrayList;


public class TestRetrieveFriendsList {
    @Test
    public void testExecute() {
        int UID = 123456;
        //create input data
        RetrieveFriendsListInputData input = new RetrieveFriendsListInputData(UID);

        //create database, output_adapter, and interactor
        RetrieveFriendsListTestDatabase database = new RetrieveFriendsListTestDatabase();
        RetrieveFriendsListTestOutputAdapter output_adapter = new RetrieveFriendsListTestOutputAdapter();
        RetrieveFriendsListInteractor interactor = new RetrieveFriendsListInteractor(database, output_adapter);
        //create sample users and add to the database
        User user1 = UserFactory.newUser(100000, "a", "", 0, true);
        User user2 = UserFactory.newUser(200000, "b", "", 0, true);
        User user3 = UserFactory.newUser(300000, "c", "", 0, true);
        database.addUser(user1);
        database.addUser(user2);
        database.addUser(user3);

        interactor.execute(input);

        //test that correct UID used on database.getFriendsListByUID
        Assertions.assertEquals(UID, database.used_UID, "Incorrect friendslist retrieved");
        //test that correct admin UID is used
        Assertions.assertEquals(output_adapter.output.getRequester(), UID, "incorrect UID returned");
        //test that correct UID/Username List is made
        System.out.println(database.friendslist);
        System.out.println(output_adapter.output.getUsers());
        for (User u : database.friendslist) {
            String s = u.getUid() + Constants.SPR + u.getName();
            Assertions.assertTrue(output_adapter.output.getUsers().contains(s),
                    "UID " + u.getUid() + " not added. ==>" + s);
        }
    }
}

