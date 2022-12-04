package server.interface_adapters.friend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;


public class ViewFriendOutputAdapater
{
    private final IfComManager comManager;
    public ViewFriendOutputAdapater(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * divide list in to a list of name and a list of int and send them to comManager instead of HashMap
     * @param list
     * @param address
     * @param peerPort
     */
    public void pushFriendList(StringBuilder list, String address, int peerPort)
    {
        String content = Constants.VIEW_FRIEND + "#" + list.toString();
        comManager.send(address, peerPort, content);
    }
}
