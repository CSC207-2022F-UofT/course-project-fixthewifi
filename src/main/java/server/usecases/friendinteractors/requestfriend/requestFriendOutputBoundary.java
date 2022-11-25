package server.usecases.friendinteractors.requestfriend;

public interface requestFriendOutputBoundary {

    /**
     * Report success to request friend to database and requester based on requesterid
     * @param requesterid
     */
    void success(int requesterid, String address, int peerPort);

    /**
     * Report failure to request friend to database and requester based on requesterid
     * @param requesterid
     */
    void fail(int requesterid, String address, int peerPort);
}
