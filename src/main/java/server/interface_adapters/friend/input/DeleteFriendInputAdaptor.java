package interface_adapters.friend.input;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.friendinteractors.deletefriend.delete_friend_input_boundary;
import usecases.friendinteractors.deletefriend.delete_friend_input_model;

public class DeleteFriendInputAdaptor {
    private IfComManager comManager;
    private delete_friend_input_boundary usecase;

    public DeleteFriendInputAdaptor(IfComManager comManager, delete_friend_input_boundary usecase)
    {
        this.usecase = usecase;
        this.comManager = comManager;
    }

    /**
     * use try catch mathod to deletefriend based on string or int
     * @param content
     */
    public void deleteFriend(String content){
        String[] arr = content.split(" ");
        String friend = arr[0];
        String requestor = arr[1];
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
