package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;

public class RequestFriendInputAdaptor {
    private IfComManager comManager;
    public RequestFriendInputAdaptor(IfComManager comManager)
    {
        this.comManager = comManager;
    }
}