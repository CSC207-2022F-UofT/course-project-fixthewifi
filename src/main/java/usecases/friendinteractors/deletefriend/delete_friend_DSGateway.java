package usecases.friendinteractors.deletefriend;

public interface delete_friend_DSGateway {
    void deleteFriendbyID(int user1, int user2);
    void deleteFriendbyName(String user1, String user2);
    boolean findUserByUID(int uid);
    boolean findUserByName(String name);
    String getAddress(int userid);
    int getPeerPort(int userid);

    String getUserName(int uid);
}
