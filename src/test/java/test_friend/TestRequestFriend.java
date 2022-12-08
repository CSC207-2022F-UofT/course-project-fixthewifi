package test_friend;

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


    /**
     * 1. test: Send a friend request to self and assert if data is recorded
     * 2. test: Send a friend request with duplicate or wrong uid to see if request is added to database
     */
    @Test
    public void testExecuteRequest() {
//        ClientComManager comManager = new ClientComManager(false);
//        ModelInterface dummyModel = new DummyModel();
//        FriendController friendController = new FriendController(comManager, dummyModel, "127.0.0.1", 000);
//        comManager.init(4444, null);
//
//        ComManager comManager1 = new ComManager(false);
//        Database database = new Database("testuser.csv", "testchat.csv");
//        FriendDataAccess dataAccess = new FriendDataAccess(database);
//        output requestFriendOutputBoundary = new output();
//        requestFriendInteractor requestFriendInteractor =
//                new requestFriendInteractor(requestFriendOutputBoundary, dataAccess);
//        RequestFriendController requestFriendController = new RequestFriendController(requestFriendInteractor);
//
//        output acceptFriendOutputBoundary = new output();
//        acceptFriendInteractor acceptFriendInteractor =
//                new acceptFriendInteractor(dataAccess, acceptFriendOutputBoundary);
//        AcceptFriendController acceptFriendController = new AcceptFriendController(acceptFriendInteractor);
//
//        InputSorter inputSorter = new InputSorter(requestFriendController, acceptFriendController,
//                null, null, null, null,
//                null, null, null, null);
//        comManager1.init(4396, inputSorter);
//
//        database.newUser(0, "A", "", "000", "000", 000);
//        //database.newUser(1, "B", "", "000", "000", 000);
//        friendController.requestFriend(0);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        String item = database.readUser(1)[9];
//
//        Assertions.assertEquals("-0", item);
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        friendController.requestFriend(0);
//        String item1 = database.readUser(1)[9];
//
//        Assertions.assertNotEquals("-0-0", item1);
    }
}