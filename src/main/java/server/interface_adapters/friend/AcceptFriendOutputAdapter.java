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
    public void success(int requestor, int friendid, String friendName, String address, int peerPort)
    {
        String content = requestor + ": " + friendName + "(" + friendid + ") accepted your friend request";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void refuse(int requestor, int friendid, String friendName, String address, int peerPort) {
        String content = requestor + ": " + friendName + "(" + friendid + ") refused to add you as friend";
        comManager.send(address, peerPort, content);
    }
}
