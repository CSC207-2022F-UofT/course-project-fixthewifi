package TestFriend;

import client.frameworks_and_drivers.communication_manager.ClientComManager;
import client.interface_adapters.controllers.FriendController;
import client.interface_adapters.model.ChatNotFoundException;
import client.interface_adapters.model.ModelInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.frameworks_and_drivers.InputSorter;
import server.frameworks_and_drivers.communication_manager.ComManager;
import server.frameworks_and_drivers.database.Database;
import server.frameworks_and_drivers.database.data_access.FriendDataAccess;
import server.interface_adapters.friend.input.AcceptFriendController;
import server.interface_adapters.friend.input.RequestFriendController;
import server.usecases.friendinteractors.acceptfriend.acceptFriendInteractor;
import server.usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;
import server.usecases.friendinteractors.requestfriend.requestFriendInteractor;
import server.usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRequestFriend {
    static class DummyModel implements ModelInterface {

        @Override
        public String getFriendName(int friendUid) {
            return null;
        }

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
        public String printChatHistory(int chatUid) {
            return null;
        }

        @Override
        public void deletePrivateChat(int friendUid) {

        }

        @Override
        public void setSelfStatus(boolean b) {

        }

        @Override
        public void addUserToChat(int parseInt, String datum, String datum1, double parseDouble, boolean online, int parseInt1, int parseInt2) {

        }

        @Override
        public void addMsg(int msgUid, int senderUid, String content, String time, int chatUid) {

        }

        @Override
        public void addGroupChat(int parseInt, String datum, String datum1, int parseInt1, List<Integer> membersUid) {

        }

        @Override
        public void notifyView(String data) {

        }

        @Override
        public String showSelfProfile() {
            return null;
        }

        @Override
        public String showChats() {
            return null;
        }

        @Override
        public String showChat(int chatUid) throws ChatNotFoundException {
            return null;
        }

        @Override
        public String showFriends() {
            return null;
        }
    }

    static class output implements requestFriendOutputBoundary, acceptFriendOutputBoundary {

        @Override
        public void success(int requesterid, String address, int peerPort) {

        }

        @Override
        public void reportToFriend(int requesterid, String requesterName, int friendid, String address, int peerPort) {

        }

        @Override
        public void fail(int requesterid, String address, int peerPort) {

        }

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

    /**
     * 1. test: Send a friend request to self and assert if data is recorded
     * 2. test: Send a friend request with duplicate or wrong uid to see if request is added to database
     */
    @Test
    public void testExecuteRequest() {
        ClientComManager comManager = new ClientComManager(false);
        ModelInterface dummyModel = new DummyModel();
        FriendController friendController = new FriendController(comManager, dummyModel, "127.0.0.1", 000);
        comManager.init(4444, null);

        ComManager comManager1 = new ComManager(false);
        Database database = new Database("testuser.csv", "testchat.csv");
        FriendDataAccess dataAccess = new FriendDataAccess(database);
        output requestFriendOutputBoundary = new output();
        requestFriendInteractor requestFriendInteractor =
                new requestFriendInteractor(requestFriendOutputBoundary, dataAccess);
        RequestFriendController requestFriendController = new RequestFriendController(requestFriendInteractor);

        output acceptFriendOutputBoundary = new output();
        acceptFriendInteractor acceptFriendInteractor =
                new acceptFriendInteractor(dataAccess, acceptFriendOutputBoundary);
        AcceptFriendController acceptFriendController = new AcceptFriendController(acceptFriendInteractor);

        InputSorter inputSorter = new InputSorter(requestFriendController, acceptFriendController,
                null, null, null, null,
                null, null, null, null);
        comManager1.init(4396, inputSorter);

        database.newUser(0, "A", "", "000", "000", 000);
        //database.newUser(1, "B", "", "000", "000", 000);
        friendController.requestFriend(0);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String item = database.readUser(1)[9];

        Assertions.assertEquals("-0", item);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        friendController.requestFriend(0);
        String item1 = database.readUser(1)[9];

        Assertions.assertNotEquals("-0-0", item1);
    }
}