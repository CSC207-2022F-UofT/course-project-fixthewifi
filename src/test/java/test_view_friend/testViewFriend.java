//package test_view_friend;
//
//import entities.CommonUser;
//
//import java.util.ArrayList;
//
//import interface_adapters.friend.ViewFriendOutputAdapater;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pseudoDSAccess.ViewFriendDSAccess;
//import usecases.friendinteractors.viewfriend.view_friend_DSGateway;
//import usecases.friendinteractors.viewfriend.view_friend_input_boundary;
//import usecases.friendinteractors.viewfriend.view_friend_input_model;
//import usecases.friendinteractors.viewfriend.view_friend_interactor;
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
