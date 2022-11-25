package server.usecases.friendinteractors.addfriend;

public interface add_friend_DSGateway {
    void addFriendbyID(int user1, int user2);
    void addFriendbyName(String user1, String user2);
    boolean findUserByUID(int uid);
    boolean findUserByName(String name);
    String getAddress(int requestorid);
    int getPeerPort(int requestorid);
}
