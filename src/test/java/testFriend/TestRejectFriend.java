package testFriend;

import client.frameworks_and_drivers.communication_manager.ClientComManager;
import client.interface_adapters.controllers.FriendController;
import client.interface_adapters.model.ModelInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.frameworks_and_drivers.InputSorter;
import server.frameworks_and_drivers.communication_manager.ComManager;
import server.frameworks_and_drivers.database.Database;
import server.frameworks_and_drivers.database.data_access.FriendDataAccess;
import server.interface_adapters.friend.input.AcceptFriendController;
import server.usecases.friendinteractors.acceptfriend.acceptFriendInteractor;
import server.usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;

public class TestRejectFriend {
    private static class DummyModel implements ModelInterface {

        @Override
        public int getSelfUid() {
            return 0;
        }

        @Override
        public void setSelfUid(int uid) {

        }

        @Override
        public String getDescription(int userUid) {
            return null;
        }

        @Override
        public void addFriend(int uid, String name, String description, double rating, boolean online) {

        }

        @Override
        public void addPrivateChat(int uid, String name, String description, int friendUid) {

        }

        @Override
        public String getPageState() {
            return null;
        }

        @Override
        public void setPageState(String state) {

        }

        @Override
        public int findPrivateChat(int friendUid) {
            return 0;
        }

        @Override
        public void setSelfName(String s) {

        }

        @Override
        public void setSelfDescription(String s) {

        }

        @Override
        public void setRating(double parseDouble) {

        }

        @Override
        public void addRequester(int uid, String name) {

        }

        @Override
        public void deleteFriend(int friendUid) {

        }

        @Override
        public void deletePrivateChat(int friendUid) {

        }
    }

    private class output implements acceptFriendOutputBoundary {

        @Override
        public void success(String[] userProfileData, String address, int ip) {

        }

        @Override
        public void refuse(int requestor, int friendid, String friendName, String address, int peerPort) {

        }

        @Override
        public void addUserToChat(String[] ChatInfo, int otherMemberUid, String address, int port) {

        }
    }


    @Test
    public void testAccept(){
        ClientComManager comManager = new ClientComManager(false);
        ModelInterface dummyModel = new TestRequestFriend.DummyModel();
        FriendController friendController = new FriendController(comManager, dummyModel, "127.0.0.1");
        comManager.init(4444, null);

        ComManager comManager1 = new ComManager(false);
        Database database = new Database("testuser.csv", "testchat.csv");
        FriendDataAccess dataAccess = new FriendDataAccess(database);
        TestAcceptFriend.output acceptFriendOutputBoundary = new TestAcceptFriend.output();
        acceptFriendInteractor acceptFriendInteractor =
                new acceptFriendInteractor(dataAccess, acceptFriendOutputBoundary);
        AcceptFriendController acceptFriendController = new AcceptFriendController(acceptFriendInteractor);
        InputSorter inputSorter = new InputSorter(null, acceptFriendController,
                null, null);
        comManager1.init(4396, inputSorter);

        database.newUser(0, "A", "", "000", "000", 000);
        database.newUser(1, "B", "", "000", "000", 000);
        friendController.requestFriend(0);
        friendController.refuseFriend(1);
        //func("$reg a 123")

        Assertions.assertEquals("", database.readUser(1)[6]);
    }
}
