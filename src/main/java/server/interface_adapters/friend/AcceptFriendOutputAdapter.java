package server.interface_adapters.friend;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;

import java.util.Arrays;


public class AcceptFriendOutputAdapter implements acceptFriendOutputBoundary
{
    private final char SPR = 30;
    private IfComManager comManager;
    public AcceptFriendOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * Send data to client of requester if accept action is done by friend
     * @param outputData
     * @param address
     * @param ip
     */
    @Override
    public void success(String[] outputData, String address, int ip)
    {

        String content = Constants.ACCEPT_FRIEND + "#" + "1 "+ String.join(String.valueOf(SPR), outputData);
        comManager.send(address, ip, content);
    }

    /**
     * Send data to client of requester if refuse action is done by friend
     * @param requestor
     * @param friendid
     * @param friendName
     * @param address
     * @param peerPort
     */
    @Override
    public void refuse(int requestor, int friendid, String friendName, String address, int peerPort)
    {
        String content = Constants.ACCEPT_FRIEND + "#" + "0 " + friendid + " " + friendName;
        comManager.send(address, peerPort, content);
    }

    /**
     * This funcion allies with success to accept friend
     * @param chatInfo
     * @param otherMemberUid
     * @param address
     * @param port
     */
    @Override
    public void addUserToChat(String[] chatInfo, int otherMemberUid, String address, int port)
    {
        String content = Constants.ACCEPT_FRIEND + "#" + "2 " + String.join(String.valueOf(SPR), chatInfo) + SPR + otherMemberUid;
        comManager.send(address, port, content);
    }
}
