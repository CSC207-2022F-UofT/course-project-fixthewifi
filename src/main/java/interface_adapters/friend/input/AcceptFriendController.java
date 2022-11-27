package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.friendinteractors.acceptfriend.acceptFriendInputBoundary;
import usecases.friendinteractors.acceptfriend.acceptFriendInputModel;

public class AcceptFriendController {
    private IfComManager comManager;
    private final acceptFriendInputBoundary usecase;

    public AcceptFriendController(IfComManager comManager, acceptFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

    /**
     * only takes int as inputs in this method accept friend
     * String one.
     * @param content
     */
    public void acceptFriend(String content)
    {
        String[] arr = content.split(" ");
        String friend = arr[0];
        String requestor = arr[1];

        int f =  Integer.parseInt(friend);
        int r = Integer.parseInt(requestor);
        acceptFriendInputModel model = new acceptFriendInputModel(f, r);
        usecase.acceptFriend(model);
    }
}
