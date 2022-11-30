package server.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.requestfriend.requestFriendInputBoundary;

public class ViewFriendController {
    private IfComManager comManager;
    private final requestFriendInputBoundary usecase;

    public ViewFriendController(IfComManager comManager, requestFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

}
