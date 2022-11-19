package usecases.friendinteractors.addfriend;


public interface add_friend_DSGateway {
    void addFriendbyID(int requesterid, int friendid);
    void failToAddFriend(int requesterid, int friendid);
}
