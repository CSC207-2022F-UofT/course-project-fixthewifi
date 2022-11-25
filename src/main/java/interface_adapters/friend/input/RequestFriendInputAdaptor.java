package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.friendinteractors.requestfriend.requestFriendInputBoundary;
import usecases.friendinteractors.requestfriend.requestFriendInputModel;

public class RequestFriendInputAdaptor {
    private IfComManager comManager;
    private final requestFriendInputBoundary usecase;

    public RequestFriendInputAdaptor(IfComManager comManager, requestFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

    /**
     * use try catch method to request a friend from type string or int input
     * @param content
     */
    public void requestFriend(String content){
        String[] arr = content.split(" ");
        String friend = arr[0];
        String requestor = arr[1];
        try {
            int f =  Integer.parseInt(friend);
            int r = Integer.parseInt(requestor);
            requestFriendInputModel model = new requestFriendInputModel(f, r);
            usecase.RequestFriend(model);
        }catch (Exception e){
            requestFriendInputModel model = new requestFriendInputModel(friend, requestor);
            usecase.RequestFriend(model);
        }
    }
}
