package usecases.friendinteractors.viewfriend;

import entities.CommonUser;

import java.util.HashMap;
import java.util.List;

public interface view_friend_output_boundary {
    void pushFriendList(List<HashMap<String, Integer>> list);
}
