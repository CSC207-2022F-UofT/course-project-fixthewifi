package server.interface_adapters.friend;


import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.deletefriend.delete_friend_output_boundary;

public class DeleteFriendOutputAdapter implements delete_friend_output_boundary {

    private final IfComManager comManager;
    public DeleteFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * To report a success to requester if delete delete a friend successfully
     * @param friendid
     * @param address
     * @param peerPort
     */
    @Override
    public void success(int friendid, String address, int peerPort)
    {
        //comManager.send("success requesterid")
        //String content = requesterid +
        String content = Constants.DELETE_FRIEND + "#" + 1 + " " + friendid;
        comManager.send(address, peerPort, content);
    }

    /**
     * To report a failure to requester if entered a uid does not exist
     * @param requesterid
     * @param address
     * @param peerPort
     */
    @Override
    public void fail(int requesterid, String address, int peerPort) {
        //comManager.send("fail requesterid")
        String content = Constants.DELETE_FRIEND + "#" + 3 + " " + requesterid;
        comManager.send(address, peerPort, content);
    }
}
