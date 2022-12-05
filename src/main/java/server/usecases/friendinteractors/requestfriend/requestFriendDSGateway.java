package server.usecases.friendinteractors.requestfriend;

import server.usecases.friendinteractors.friendCommonsDSGateway;

public interface requestFriendDSGateway extends friendCommonsDSGateway {

    /**
     * Request friend by userid. Save this request to database
     * @param requester
     * @param friend
     */
    void requestFriendbyID(int requester, int friend);

    /**
     * Request friend by username. Save this request to database
     * @param requester
     * @param friend
     */
    void requestFriendbyName(String requester, String friend);

    public boolean notAlreadyFriend(int requester, int friend);

    public boolean notAlreadyRequested(int requester, int friend);
}
