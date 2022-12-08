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
     * Report to requester if friend request is success
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
     * Report to friend that a request tried to request a friend
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
     * Send to requester if requester entered a wrong friend id that is not found or duplicate
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
