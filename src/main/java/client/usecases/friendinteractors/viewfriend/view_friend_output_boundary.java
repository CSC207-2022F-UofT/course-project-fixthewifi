package client.usecases.friendinteractors.viewfriend;

import java.util.List;

public interface view_friend_output_boundary {
    void pushFriendList(List<String> list, String address, int peerPort);
}
