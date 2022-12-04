package test_usecases.retrieve_friendslist;
import server.entities.CommonUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.frameworks_and_drivers.Constants;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInputData;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInteractor;

import java.util.ArrayList;


public class TestRetrieveFriendsList {
    @Test
    public void testExecute(){
        int UID = 123456;
        //create input data
        RetrieveFriendsListInputData input = new RetrieveFriendsListInputData(UID);

        //create database, output_adapter, and interactor
        RetrieveFriendsListTestDatabase database = new RetrieveFriendsListTestDatabase();
        RetrieveFriendsListTestOutputAdapter output_adapter = new RetrieveFriendsListTestOutputAdapter();
        RetrieveFriendsListInteractor interactor = new RetrieveFriendsListInteractor(database, output_adapter);
        //create sample users and add to the database
        CommonUser user1 = new CommonUser(111111, "1user", 0);
        CommonUser user2 = new CommonUser(222222, "2user", 1);
        CommonUser user3 = new CommonUser(333333, "3user", 0);
        database.addUser(user1);
        database.addUser(user2);
        database.addUser(user3);

        interactor.execute(input);

        //test that correct UID used on database.getFriendsListByUID
        Assertions.assertEquals(UID, database.used_UID, "Incorrect friendslist retrieved");
        //test that correct UID list is made
        Assertions.assertEquals(output_adapter.output.getRequester(), UID, "incorrect UID returned");
        ArrayList<CommonUser> expected_users = database.getFriendsListByUID(UID);
        ArrayList<String> actual_users = output_adapter.output.getUsers();
        for (int i = 0; i < expected_users.size(); i++){
            String user_data = actual_users.get(i);
            int j = user_data.indexOf(Constants.SPR);
            int extracted_UID = Integer.parseInt(user_data.substring(0, j));
            String extracted_username = user_data.substring(j + 1);
            Assertions.assertEquals(expected_users.get(i).getUid(), extracted_UID, "Incorrect UID added");
            // TODO fix once username feature works


        }
    }

}
