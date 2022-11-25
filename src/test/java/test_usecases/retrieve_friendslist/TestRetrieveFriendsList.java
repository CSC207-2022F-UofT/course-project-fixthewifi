package test_usecases.retrieve_friendslist;
import server.entities.CommonUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInputData;
import server.usecases.retrieve_friendslist.RetrieveFriendsListInteractor;


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
        for (CommonUser u : database.friendslist){
            Assertions.assertTrue(output_adapter.output.getUIDs().contains(u.getUid()), "UID not added");
            //TODO: Assertions.assertTrue(output_adapter.output.getUsernames().contains(
            // u.getUsername()), "username not added");
        }
    }

}
