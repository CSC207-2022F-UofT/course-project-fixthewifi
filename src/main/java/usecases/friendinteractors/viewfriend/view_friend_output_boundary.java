package usecases.friendinteractors.viewfriend;

import entities.CommonUser;
import java.util.ArrayList;

public interface view_friend_output_boundary {

    /**
     * Push a list of friend to client size
     * @param arraylist
     */
    void pushFriendList(ArrayList<CommonUser> arraylist);

    ArrayList<CommonUser> pushFriendList_test(ArrayList<CommonUser> arraylist);
}
