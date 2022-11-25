package usecases.friendinteractors.acceptfriend;

public interface acceptFriendDSGateway {
    void acceptFriendbyID(int user1, int user2);
    void acceptFriendbyName(String user1, String user2);
    boolean findUserByUID(int uid);
    boolean findUserByName(String name);
    String getAddress(int requestorid);
    int getPeerPort(int requestorid);
}
