package usecases.friendinteractors.viewfriend;

import entities.CommonUser;
import usecases.friendinteractors.addfriend.add_friend_input_model;

import java.util.HashMap;
import java.util.List;

public class view_friend_interactor implements view_friend_input_boundary {
    final view_friend_output_boundary output;
    final view_friend_DSGateway dataBase;

    public view_friend_interactor(view_friend_DSGateway dataBase, view_friend_output_boundary output){
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void ViewFriend(view_friend_input_model model) {
        List<HashMap<String, Integer>> list = dataBase.getFriendList();
        output.pushFriendList(list);
    }
}
