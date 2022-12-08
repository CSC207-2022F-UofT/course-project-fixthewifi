package test_usecases.retrieve_friendslist;
import server.entities.User;
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
        for (User u : database.friendslist){
            Assertions.assertTrue(output_adapter.output.getUIDs().contains(u.getUid()), "UID not added");
            //TODO: Assertions.assertTrue(output_adapter.output.getUsernames().contains(
            // u.getUsername()), "username not added");
        }
    }

}
