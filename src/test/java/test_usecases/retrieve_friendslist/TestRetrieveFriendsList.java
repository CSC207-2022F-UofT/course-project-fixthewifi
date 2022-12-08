package test_usecases.retrieve_friendslist;
import server.entities.User;
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
//        User User = new User(111111, "1user", 0);
//        User user2 = new User(222222, "2user", 1);
//        User user3 = new User(333333, "3user", 0);
//        database.addUser(User);
//        database.addUser(user2);
//        database.addUser(user3);

        interactor.execute(input);

        //test that correct UID used on database.getFriendsListByUID
        Assertions.assertEquals(UID, database.used_UID, "Incorrect friendslist retrieved");
        //test that correct UID list is made
        Assertions.assertEquals(output_adapter.output.getRequester(), UID, "incorrect UID returned");
//        for (User u : database.friendslist){
//            Assertions.assertTrue(output_adapter.output.getUIDs().contains(u.getUid()), "UID not added");
//            //TODO: Assertions.assertTrue(output_adapter.output.getUsernames().contains(
//            // u.getUsername()), "username not added");
//        ArrayList<CommonUser> expected_users = database.getFriendsListByUID(UID);
//        ArrayList<String> actual_users = output_adapter.output.getUsers();
//        for (int i = 0; i < expected_users.size(); i++){
//            String user_data = actual_users.get(i);
//            int j = user_data.indexOf(Constants.SPR);
//            int extracted_UID = Integer.parseInt(user_data.substring(0, j));
//            // TODO fix once username feature works
//            // String extracted_username = user_data.substring(j + 1);
//            Assertions.assertEquals(expected_users.get(i).getUid(), extracted_UID, "Incorrect UID added");
        }
    }

