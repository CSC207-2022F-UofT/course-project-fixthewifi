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

    @Override
    public void success(int requesterid, String address, int peerPort)
    {
        String content = requesterid + ": request friend successfully";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void reportToFriend(int requesterid, String requesterName, int friendid, String address, int peerPort) {
        char spr = 30;
        String content = Constants.REQUEST_FRIEND+"#"+String.join(String.valueOf(spr), String.valueOf(requesterid), requesterName);
        comManager.send(address, peerPort, content);
    }

    @Override
    public void fail(int requesterid, String address, int peerPort)
    {
        String content = requesterid + ": failed to request friend, uid or username not found";
        comManager.send(address, peerPort, content);
    }
}
