package test_view_friend;

import interface_adapters.friend.DeleteFriendOutputAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pseudoDSAccess.DeleteFriendDSAccess;
import usecases.friendinteractors.deletefriend.delete_friend_input_model;
import usecases.friendinteractors.deletefriend.delete_friend_interactor;

import java.util.ArrayList;

public class testDeleteFriend {
    @Test
    public void testDeleteFriendbyName(){
        //create interactor
        DeleteFriendDSAccess dataBase = new DeleteFriendDSAccess();
        DeleteFriendOutputAdapter outputAdapater = new DeleteFriendOutputAdapter();
        delete_friend_interactor interactor = new delete_friend_interactor(dataBase, outputAdapater);
        delete_friend_input_model input_model = new delete_friend_input_model("A", "B");
        //create test data
        ArrayList<String> output1 = interactor.DeleteFriend_test1(input_model);
        Integer output = output1.size();
        //assertion
        Assertions.assertEquals(1, output);
    }

    @Test
    public void testDeleteFriendbyUID(){
        //create interactor
        DeleteFriendDSAccess dataBase = new DeleteFriendDSAccess();
        DeleteFriendOutputAdapter outputAdapater = new DeleteFriendOutputAdapter();
        delete_friend_interactor interactor = new delete_friend_interactor(dataBase, outputAdapater);
        delete_friend_input_model input_model = new delete_friend_input_model(1, 2);
        //create test data
        ArrayList<Integer> output1 = interactor.DeleteFriend_test2(input_model);
        Integer output = output1.size();
        //assertion
        Assertions.assertEquals(1, output);
    }

    @Test
    public void testDeleteFriendFailure(){
        //create interactor
        DeleteFriendDSAccess dataBase = new DeleteFriendDSAccess();
        DeleteFriendOutputAdapter outputAdapater = new DeleteFriendOutputAdapter();
        delete_friend_interactor interactor = new delete_friend_interactor(dataBase, outputAdapater);
        delete_friend_input_model input_model = new delete_friend_input_model(10000, 1000);
        //create test data
        //boolean output1 = interactor.DeleteFriend_test2(input_model);
        //assertion
        //Assertions.assertFalse(output1);
    }
}

//Useless
