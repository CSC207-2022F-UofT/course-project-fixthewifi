package server.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;

public class ViewFriendInputAdaptor {
    private IfComManager comManager;
    public ViewFriendInputAdaptor(IfComManager comManager)
    {
        this.comManager = comManager;
    }

}
