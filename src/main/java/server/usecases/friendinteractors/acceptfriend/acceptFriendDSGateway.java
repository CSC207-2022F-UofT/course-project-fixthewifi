package server.usecases.friendinteractors.acceptfriend;

public interface acceptFriendDSGateway {
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

    String getuserName(int userid);
    String getAddress(int userid);
    int getPeerPort(int userid);
}