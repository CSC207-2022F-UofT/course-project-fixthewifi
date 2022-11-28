package usecases.friendinteractors.acceptfriend;

import usecases.friendinteractors.friendCommonsDSGateway;

public interface acceptFriendDSGateway extends friendCommonsDSGateway {
    /**
     * save this change to database
     * @param friendid
     * @param requesterid
     */
    void acceptFriendbyID(int friendid, int requesterid);

    /**
     * save this change to database
     * @param friendid
     * @param requesterid
     */
    void refuseFriendbyID(int friendid, int requesterid);
}
