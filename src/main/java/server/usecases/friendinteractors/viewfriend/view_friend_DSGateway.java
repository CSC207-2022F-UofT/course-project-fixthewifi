package server.usecases.friendinteractors.viewfriend;

import server.usecases.friendinteractors.friendCommonsDSGateway;

public interface view_friend_DSGateway extends friendCommonsDSGateway {
    StringBuilder getFriendList(int requestorid);
}
