package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.friendinteractors.requestfriend.requestFriendInputBoundary;

public class ViewFriendInputAdaptor {
    private IfComManager comManager;
    private final requestFriendInputBoundary usecase;

    public ViewFriendInputAdaptor(IfComManager comManager, requestFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

}
