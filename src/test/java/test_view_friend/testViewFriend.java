package test_view_friend;

import entities.CommonUser;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecases.friendinteractors.viewfriend.view_friend_DSGateway;
import usecases.friendinteractors.viewfriend.view_friend_input_boundary;
import usecases.friendinteractors.viewfriend.view_friend_output_boundary;

/**
 * @author Zhuo Zhang
 */

public class testViewFriend {
    /**
     * Test view friend feature by getting friend list of user of requestoerid
     */
    private view_friend_DSGateway dataBase;
    private view_friend_input_boundary input;
    private final int requesterid = 123456;
    CommonUser user1 = new CommonUser(100000, "a", 1);
    CommonUser user2 = new CommonUser(200000, "b", 2);
    CommonUser user3 = new CommonUser(300000, "c", 3);

    @Test
    public void testViewFriendInteractor(){
        ArrayList<CommonUser> friendlist = dataBase.getFriendList(123456);
        ArrayList<CommonUser> friendlistFinale = new ArrayList<>();
        friendlistFinale.add(user1);
        friendlistFinale.add(user2);
        friendlistFinale.add(user3);


    }
}
