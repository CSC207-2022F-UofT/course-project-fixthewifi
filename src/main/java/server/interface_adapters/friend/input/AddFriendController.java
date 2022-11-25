package server.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.addfriend.AddFriendInputBoundary;
import server.usecases.friendinteractors.addfriend.add_friend_input_model;

public class AddFriendController {
    private IfComManager comManager;
    private AddFriendInputBoundary usecase;

    public AddFriendController(IfComManager comManager, AddFriendInputBoundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

    /**
     * use try catch method to first convert input to integer and call input model in integer one, if failed, call
     * String one.
     * @param content
     */
    public void addFriend(String content)
    {
        String[] arr = content.split(" ");
        String friend = arr[0];
        String requestor = arr[1];
        try {
            int f =  Integer.parseInt(friend);
            int r = Integer.parseInt(requestor);
            add_friend_input_model model = new add_friend_input_model(f, r);
            usecase.AddFriend(model);
        }catch (Exception e){
            add_friend_input_model model = new add_friend_input_model(friend, requestor);
            usecase.AddFriend(model);
        }
    }
}
