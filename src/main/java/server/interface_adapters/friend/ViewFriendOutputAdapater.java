package server.interface_adapters.friend;

import java.util.List;

import server.frameworks_and_drivers.communication_manager.IfComManager;


public class ViewFriendOutputAdapater
{
    private final IfComManager comManager;
    public ViewFriendOutputAdapater(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    public void pushFriendList(List<String> list, String address, int peerPort)
    {
        String content = list.toString();
        comManager.send(address, peerPort, content);
    }
}
