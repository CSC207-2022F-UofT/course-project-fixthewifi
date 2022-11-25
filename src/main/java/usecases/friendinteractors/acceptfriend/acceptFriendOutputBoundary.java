package usecases.friendinteractors.acceptfriend;

public interface acceptFriendOutputBoundary {
    void success(int requestor, String address, int peerPort);
    void fail(int requestor, String address, int peerPort);
}
