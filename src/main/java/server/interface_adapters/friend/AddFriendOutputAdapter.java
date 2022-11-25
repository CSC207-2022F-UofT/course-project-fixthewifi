package server.interface_adapters.friend;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.addfriend.add_friend_output_boundary;


public class AddFriendOutputAdapter implements add_friend_output_boundary
{
    private IfComManager comManager;
    public AddFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void success(int requestor, String address, int peerPort)
    {
        //comManager.send("success")
        String content = requestor + ": successfully add friend.";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void fail(int requestor, String address, int peerPort) {
        //comManager.send("fail")
        String content = requestor + ": failed to add friend. UID or userName may be wrong";
        comManager.send(address, peerPort, content);
    }
}
