package pseudoDSAccess;

import entities.CommonUser;
import usecases.friendinteractors.viewfriend.view_friend_DSGateway;

import java.util.ArrayList;

public class ViewFriendDSAccess implements view_friend_DSGateway {
    public ViewFriendDSAccess() {
    }

    @Override
    public ArrayList<Integer> getFriendList_test(int requestorid) {
        CommonUser user1 = new CommonUser(100000, "a", 1);
        CommonUser user2 = new CommonUser(200000, "b", 2);
        CommonUser user3 = new CommonUser(300000, "c", 3);
        ArrayList<Integer> friendlist = new ArrayList<>();
        friendlist.add(user1.getUid());
        friendlist.add(user2.getUid());
        friendlist.add(user3.getUid());
        return friendlist;
    }

    @Override
    public ArrayList<CommonUser> getFriendList(int requestor) {
        return null;
    }
}
