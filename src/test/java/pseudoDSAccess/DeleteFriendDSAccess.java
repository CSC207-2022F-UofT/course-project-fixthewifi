package pseudoDSAccess;

import entities.CommonUser;
import usecases.friendinteractors.deletefriend.delete_friend_DSGateway;

import java.util.ArrayList;

public class DeleteFriendDSAccess implements delete_friend_DSGateway {
    CommonUser user1 = new CommonUser(100000, "a", 1);
    CommonUser user2 = new CommonUser(200000, "b", 0);
    CommonUser user3 = new CommonUser(300000, "c", 1);

    @Override
    public void deleteFriendbyID(int user1, int user2) {

    }

    @Override
    public void deleteFriendbyName(String user1, String user2) {

    }

    @Override
    public boolean findUserByUID(int uid) {
        return false;
    }

    @Override
    public boolean findUserByName(String name) {
        return false;
    }
}
