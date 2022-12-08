package server.usecases.friendinteractors.viewfriend;


public interface view_friend_output_boundary {
    void pushFriendList(StringBuilder list, String address, int peerPort);
}
