package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;

public class ViewFriendInputAdaptor {
    private IfComManager comManager;
    public ViewFriendInputAdaptor(IfComManager comManager)
    {
        this.comManager = comManager;
    }

}
