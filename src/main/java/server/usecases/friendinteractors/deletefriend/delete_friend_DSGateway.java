package usecases.friendinteractors.deletefriend;

import usecases.friendinteractors.friendCommonsDSGateway;

public interface delete_friend_DSGateway extends friendCommonsDSGateway {
    void deleteFriendbyID(int user1, int user2);
    void deleteFriendbyName(String user1, String user2);
}
