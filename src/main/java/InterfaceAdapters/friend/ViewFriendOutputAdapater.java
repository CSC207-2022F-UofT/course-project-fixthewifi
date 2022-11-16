package interface_adapters.friend;

import usecases.friendinteractors.viewfriend.view_friend_output_boundary;

import java.util.HashMap;
import java.util.List;

public class ViewFriendOutputAdapater implements view_friend_output_boundary {

    @Override
    public void pushFriendList(List<HashMap<String, Integer>> list){
        //comManager.send(list)
    }
}
