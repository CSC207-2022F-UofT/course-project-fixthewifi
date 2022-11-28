package server.usecases.friendinteractors.acceptfriend;
import java.util.Objects;

public class acceptFriendInteractor implements acceptFriendInputBoundary {
    final acceptFriendOutputBoundary output;
    final acceptFriendDSGateway dataBase;


    public acceptFriendInteractor(acceptFriendDSGateway dataBase, acceptFriendOutputBoundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * the whole accept friend should be re-designed because it is a click from friend not a search from requester
     * @param model
     */
    @Override
    public void acceptFriend(acceptFriendInputModel model) {
        int friendid = model.getFriendid();
        int requesterid = model.getRequesterid();
        String friendName = dataBase.getuserName(friendid);
        int requesterPeerPort = dataBase.getPeerPort(requesterid);
        String requesterAddress = dataBase.getAddress(requesterid);
        int friendPeerPort = dataBase.getPeerPort(friendid);
        String friendAddress = dataBase.getAddress(friendid);
        String ifAccept = model.getIfAccept();
        if(Objects.equals(ifAccept, "True")){
            dataBase.acceptFriendbyID(friendid, requesterid);
            output.success(requesterid, friendid, friendName, requesterAddress, requesterPeerPort);
        }
        else{
            dataBase.refuseFriendbyID(friendid, requesterid);
            output.refuse(requesterid, friendid, friendName, requesterAddress, requesterPeerPort);
        }
    }
}