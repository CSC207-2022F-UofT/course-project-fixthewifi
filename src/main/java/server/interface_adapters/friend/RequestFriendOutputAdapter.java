package server.interface_adapters.friend;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

public class RequestFriendOutputAdapter implements requestFriendOutputBoundary {
    private final IfComManager comManager;
    public RequestFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }


    /**
     * Send success info to requester if request is done
     * @param requesterid
     * @param address
     * @param peerPort
     */
    @Override
    public void success(int requesterid, String address, int peerPort)
    {
        String content = Constants.REQUEST_FRIEND+ "#" + 1;
        comManager.send(address, peerPort, content);
    }

    /**
     * Report a new request friend action to friend from requester
     * @param requesterid
     * @param requesterName
     * @param friendid
     * @param address
     * @param peerPort
     */
    @Override
    public void reportToFriend(int requesterid, String requesterName, int friendid, String address, int peerPort) {
        String content = Constants.REQUEST_FRIEND + "#" + 2 + " " + requesterid + " " + requesterName;
        comManager.send(address, peerPort, content);
    }

    /**
     * Report to requester a failure
     * @param requesterid
     * @param address
     * @param peerPort
     */
    @Override
    public void fail(int requesterid, String address, int peerPort)
    {
        String content = Constants.REQUEST_FRIEND+ "#" + 0;
        comManager.send(address, peerPort, content);
    }
}
