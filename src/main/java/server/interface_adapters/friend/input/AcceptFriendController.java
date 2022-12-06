package server.interface_adapters.friend.input;

import server.usecases.friendinteractors.acceptfriend.acceptFriendInputBoundary;
import server.usecases.friendinteractors.acceptfriend.acceptFriendInputModel;

public class AcceptFriendController {
    private final acceptFriendInputBoundary usecase;

    public AcceptFriendController(acceptFriendInputBoundary usecase)
    {
        this.usecase = usecase;
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
        String ifAccept = arr[2];

        int f =  Integer.parseInt(friend);
        int r = Integer.parseInt(requestor);
        acceptFriendInputModel model = new acceptFriendInputModel(f, r, ifAccept);
        usecase.acceptFriend(model);
    }
}
