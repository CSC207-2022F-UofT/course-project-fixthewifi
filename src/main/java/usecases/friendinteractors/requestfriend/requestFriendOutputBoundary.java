package usecases.friendinteractors.requestfriend;

public interface requestFriendOutputBoundary {

    /**
     * Report success to request friend to database and requester based on requesterid
     * @param requesterid
     */
    void success(int requesterid);

    /**
     * Report failure to request friend to database and requester based on requesterid
     * @param requesterid
     */
    void fail(int requesterid);
}
