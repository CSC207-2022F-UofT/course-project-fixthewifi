package client.usecases.friendinteractors.viewfriend;

import server.usecases.friendinteractors.viewfriend.view_friend_DSGateway;
import server.usecases.friendinteractors.viewfriend.view_friend_input_boundary;
import server.usecases.friendinteractors.viewfriend.view_friend_input_model;
import server.usecases.friendinteractors.viewfriend.view_friend_output_boundary;

import java.util.List;

public class view_friend_interactor implements view_friend_input_boundary {
    final view_friend_output_boundary output;
    final server.usecases.friendinteractors.viewfriend.view_friend_DSGateway dataBase;

    public view_friend_interactor(view_friend_DSGateway dataBase, view_friend_output_boundary output){
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void ViewFriend(view_friend_input_model model) {
        List<String> list = dataBase.getFriendList(model.getRequesterid());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());
        output.pushFriendList(list, address, peerPort);
    }
}
