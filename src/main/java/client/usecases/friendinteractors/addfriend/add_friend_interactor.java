package client.usecases.friendinteractors.addfriend;

import server.usecases.friendinteractors.addfriend.AddFriendInputBoundary;
import server.usecases.friendinteractors.addfriend.add_friend_DSGateway;
import server.usecases.friendinteractors.addfriend.add_friend_input_model;
import server.usecases.friendinteractors.addfriend.add_friend_output_boundary;

public class add_friend_interactor implements AddFriendInputBoundary {
    final add_friend_output_boundary output;
    final server.usecases.friendinteractors.addfriend.add_friend_DSGateway dataBase;


    public add_friend_interactor(add_friend_DSGateway dataBase, add_friend_output_boundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void AddFriend(add_friend_input_model model)
    {
        boolean bool1 = dataBase.findUserByUID(model.getFriendid());
        boolean bool2 = dataBase.findUserByName(model.getFriendName());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());

        if (bool1){
            dataBase.addFriendbyID(model.getFriendid(), model.getRequesterid());
            output.success(model.getRequesterid(), address, peerPort);
        }
        if (bool2){
            dataBase.addFriendbyName(model.getFriendName(), model.getRequesterName());
            output.success(model.getRequesterid(), address, peerPort);
        }
        output.fail(model.getRequesterid(), address, peerPort);
    }
}
