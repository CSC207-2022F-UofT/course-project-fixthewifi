package usecases.friendinteractors.viewfriend;

import entities.CommonUser;
import java.util.ArrayList;

public interface view_friend_output_boundary {
    void pushFriendList(ArrayList<CommonUser> arraylist);
}
