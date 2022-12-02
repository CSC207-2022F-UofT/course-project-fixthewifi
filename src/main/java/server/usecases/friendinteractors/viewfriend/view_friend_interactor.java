package server.usecases.friendinteractors.viewfriend;

import java.util.ArrayList;
import java.util.HashMap;

public class view_friend_interactor implements view_friend_input_boundary {
    final usecases.friendinteractors.viewfriend.view_friend_output_boundary output;
    final usecases.friendinteractors.viewfriend.view_friend_DSGateway dataBase;

    public view_friend_interactor(usecases.friendinteractors.viewfriend.view_friend_DSGateway dataBase, usecases.friendinteractors.viewfriend.view_friend_output_boundary output){
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void ViewFriend(view_friend_input_model model) {
        ArrayList<HashMap<String, Integer>> list = dataBase.getFriendList(model.getRequesterid());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());
        output.pushFriendList(list, address, peerPort);
    }
}