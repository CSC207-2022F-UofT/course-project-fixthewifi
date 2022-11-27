package usecases.friendinteractors.acceptfriend;

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
        String friendName = model.getFriendName();
        int requesterPeerPort = dataBase.getPeerPort(requesterid);
        String requesterAddress = dataBase.getAddress(requesterid);
        int friendPeerPort = dataBase.getPeerPort(friendid);
        String friendAddress = dataBase.getAddress(friendid);

        dataBase.acceptFriendbyID(friendid, requesterid);
        dataBase.refuseFriendbyID(friendid, requesterid);
        output.success(requesterid, friendid, friendName, requesterAddress, requesterPeerPort);
        output.refuse(requesterid, friendid, friendName, requesterAddress, requesterPeerPort);
    }
}
