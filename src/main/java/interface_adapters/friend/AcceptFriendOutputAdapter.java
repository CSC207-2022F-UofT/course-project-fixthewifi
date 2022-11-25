package interface_adapters.friend;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;


public class AcceptFriendOutputAdapter implements acceptFriendOutputBoundary
{
    private IfComManager comManager;
    public AcceptFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void success(int requestor, String address, int peerPort)
    {
        //comManager.send("success")
        String content = requestor + ": successfully accept friend.";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void fail(int requestor, String address, int peerPort) {
        //comManager.send("fail")
        String content = requestor + ": failed to accept friend. UID or userName may be wrong";
        comManager.send(address, peerPort, content);
    }
}
