package server.interface_adapters.friend;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;


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
        String content = Constants.ACCEPT_FRIEND + "#" + friendid + " " + friendName + " True";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void refuse(int requestor, int friendid, String friendName, String address, int peerPort)
    {
        String content = Constants.ACCEPT_FRIEND + "#" + friendid + " " + friendName + " False";
        comManager.send(address, peerPort, content);
    }
}
