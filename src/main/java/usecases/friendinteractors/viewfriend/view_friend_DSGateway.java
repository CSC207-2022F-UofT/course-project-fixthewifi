package usecases.friendinteractors.viewfriend;

import entities.CommonUser;
import java.util.ArrayList;

public interface view_friend_DSGateway {

    /**
     * Request a list of friend from database
     * @return
     */
    ArrayList<CommonUser> getFriendList(int requestor);
    ArrayList<Integer> getFriendList_test(int requestor);

}
