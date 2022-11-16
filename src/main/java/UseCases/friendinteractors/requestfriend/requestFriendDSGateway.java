package usecases.friendinteractors.requestfriend;

public interface requestFriendDSGateway {
    boolean findUserByUID(int uid);
    boolean findUserByName(String name);
    void requestFriendbyID(int requester, int friend);
    void requestFriendbyName(String requester, String friend);
}
