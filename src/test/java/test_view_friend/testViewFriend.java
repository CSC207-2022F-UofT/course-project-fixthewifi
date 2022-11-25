//package test_view_friend;
//
//import server.entities.CommonUser;
//
//import java.util.ArrayList;
//
//import server.friend.interface_adapters.ViewFriendOutputAdapater;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pseudoDSAccess.ViewFriendDSAccess;
//import server.viewfriend.friendinteractors.usecases.view_friend_DSGateway;
//import server.viewfriend.friendinteractors.usecases.view_friend_input_boundary;
//import server.viewfriend.friendinteractors.usecases.view_friend_input_model;
//import server.viewfriend.friendinteractors.usecases.view_friend_interactor;
//
//import static org.junit.Assert.assertArrayEquals;
//
///**
// * @author Zhuo Zhang
// */
//
//public class testViewFriend {
//    /**
//     * Test view friend feature by getting friend list of user of requestoerid
//     */
//    final int requestor = 123456;
//    @Test
//    public void test_ViewFriend(){
//        //create interactor
//        ViewFriendDSAccess dataBase = new ViewFriendDSAccess();
//        ViewFriendOutputAdapater outputAdapater = new ViewFriendOutputAdapater();
//        view_friend_interactor interactor = new view_friend_interactor(dataBase, outputAdapater);
//        view_friend_input_model input_model = new view_friend_input_model(123456);
//        //create test data
//        ArrayList<Integer> output = interactor.ViewFriend_test(input_model);
//        //make assertion
//        Assertions.assertNotNull(output);
//    }
//}
