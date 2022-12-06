package server.usecases.friendinteractors.acceptfriend;

public interface acceptFriendOutputBoundary {
    void success(String[] userProfileData, String address, int ip);
    void refuse(int requestor, int friendid, String friendName, String address, int peerPort);
}
