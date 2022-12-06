package server.interface_adapters.friend.input;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.friendinteractors.deletefriend.delete_friend_input_boundary;
import server.usecases.friendinteractors.deletefriend.delete_friend_input_model;
import server.usecases.friendinteractors.deletefriend.delete_friend_interactor;

public class DeleteFriendController {
    private IfComManager comManager;
    private delete_friend_input_boundary usecase;

    public DeleteFriendController(delete_friend_input_boundary usecase)
    {
        this.usecase = usecase;
    }

    /**
     * use try catch mathod to deletefriend based on string or int
     * @param content
     */
    public void deleteFriend(String content){
        String[] arr = content.split(" ");
        String friend = arr[0];
        String requestor = arr[1];
        System.out.println("DeleteFriendController");
        try {
            int f =  Integer.parseInt(friend);
            int r = Integer.parseInt(requestor);
            delete_friend_input_model model = new delete_friend_input_model(f, r);
            usecase.DeleteFriend(model);
        }catch (Exception e){
            delete_friend_input_model model = new delete_friend_input_model(friend, requestor);
            usecase.DeleteFriend(model);
        }
    }
}
