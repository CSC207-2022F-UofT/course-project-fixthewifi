package client.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;

public class DeleteFriendInputAdaptor {
    private IfComManager comManager;
    public DeleteFriendInputAdaptor(IfComManager comManager)
    {
        this.comManager = comManager;
    }
}
