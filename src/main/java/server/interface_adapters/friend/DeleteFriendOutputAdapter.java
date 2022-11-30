package server.interface_adapters.friend;


import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.deletefriend.delete_friend_output_boundary;

public class DeleteFriendOutputAdapter implements delete_friend_output_boundary {

    private final IfComManager comManager;
    public DeleteFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    @Override
    public void success(int requesterid, String address, int peerPort)
    {
        //comManager.send("success requesterid")
        String content = requesterid + ": delete friend successfully";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void reportSuccess(int friendid, int requesterid, String requesterName, String address, int peerPort) {
        String content = friendid + ":" + requesterName + "(" + requesterid + ") has delete you as friend";
        comManager.send(address, peerPort, content);
    }

    @Override
    public void fail(int requesterid, String address, int peerPort) {
        //comManager.send("fail requesterid")
        String content = requesterid + ": failed to delete friend. Wrong username or userid entered";
        comManager.send(address, peerPort, content);
    }
}
