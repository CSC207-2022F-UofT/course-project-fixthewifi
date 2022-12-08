package server.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.requestfriend.requestFriendInputBoundary;
import server.usecases.friendinteractors.viewfriend.view_friend_input_model;

public class ViewFriendController {
    private IfComManager comManager;
    private final requestFriendInputBoundary usecase;

    public ViewFriendController(IfComManager comManager, requestFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

    public void viewFriend(String content){
        int requesterid = Integer.parseInt(content);
        view_friend_input_model model = new view_friend_input_model(requesterid);
    }
}
