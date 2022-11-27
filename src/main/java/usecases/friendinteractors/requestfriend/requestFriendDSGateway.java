package usecases.friendinteractors.requestfriend;

public interface requestFriendDSGateway {
    /**
     * Find the user by userid.
     * @param uid
     * @return
     */
    boolean findUserByUID(int uid);

    /**
     * Find the user by username.
     * @param name
     * @return
     */
    boolean findUserByName(String name);

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

    String getAddress(int userid);
    int getPeerPort(int userid);
}
