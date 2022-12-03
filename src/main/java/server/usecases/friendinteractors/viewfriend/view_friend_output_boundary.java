package usecases.friendinteractors.viewfriend;


import java.util.ArrayList;
import java.util.HashMap;

public interface view_friend_output_boundary {
    void pushFriendList(ArrayList<HashMap<String, Integer>> list, String address, int peerPort);
}
