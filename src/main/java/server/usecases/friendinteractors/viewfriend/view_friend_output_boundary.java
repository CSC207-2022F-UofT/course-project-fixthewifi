package server.usecases.friendinteractors.viewfriend;


import java.util.ArrayList;
import java.util.HashMap;

public interface view_friend_output_boundary {
    void pushFriendList(StringBuilder list, String address, int peerPort);
}
