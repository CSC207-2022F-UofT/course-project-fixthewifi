package server.usecases.friendinteractors.acceptfriend;

public interface acceptFriendOutputBoundary {
    void success(int requestor, int friendid, String friendName, String address, int peerPort);
    void refuse(int requestor, int friendid, String friendName, String address, int peerPort);
}
