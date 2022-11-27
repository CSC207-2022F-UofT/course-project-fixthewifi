package usecases.friendinteractors.acceptfriend;

public interface acceptFriendDSGateway {
    void acceptFriendbyID(int user1, int user2);
    void refuseFriendbyID(int user1, int user2);
    String getAddress(int userid);
    int getPeerPort(int userid);
}
