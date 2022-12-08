package server.usecases.friendinteractors.deletefriend;

import server.usecases.friendinteractors.friendCommonsDSGateway;

public interface delete_friend_DSGateway extends friendCommonsDSGateway {
    void deleteFriendbyID(int User, int user2);
    void deleteFriendbyName(String User, String user2);

    void deleteChat(int chatUid);
}
