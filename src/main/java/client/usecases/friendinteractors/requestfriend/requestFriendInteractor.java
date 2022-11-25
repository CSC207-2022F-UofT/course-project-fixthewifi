package client.usecases.friendinteractors.requestfriend;

import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;
import server.usecases.friendinteractors.requestfriend.requestFriendInputBoundary;
import server.usecases.friendinteractors.requestfriend.requestFriendInputModel;
import server.usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

public class requestFriendInteractor implements requestFriendInputBoundary {
    final requestFriendOutputBoundary output;
    final server.usecases.friendinteractors.requestfriend.requestFriendDSGateway dataBase;

    public requestFriendInteractor(requestFriendOutputBoundary output, requestFriendDSGateway dataBase){
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * In interactor, request friend from based on id or name and report if success or failure
     * @param model
     */
    @Override
    public void RequestFriend(requestFriendInputModel model){
        boolean b1 = dataBase.findUserByUID(model.getFriendid());
        boolean b2 = dataBase.findUserByName(model.getFriendName());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());
        if (b1){
            dataBase.requestFriendbyID(model.getRequesterid(), model.getFriendid());
            output.success(model.getFriendid(), address, peerPort);
        }
        if (b2){
            dataBase.requestFriendbyName(model.getRequesterName(), model.getFriendName());
            output.success(model.getFriendid(), address, peerPort);
        }
        output.fail(model.getFriendid(), address, peerPort);
    }
}
