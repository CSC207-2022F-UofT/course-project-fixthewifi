package usecases.friendinteractors.requestfriend;

public class requestFriendInteractor implements requestFriendInputBoundary{
    final requestFriendOutputBoundary output;
    final requestFriendDSGateway dataBase;

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
        int requesterPeerPort = dataBase.getPeerPort(model.getRequesterid());
        String requesterAddress = dataBase.getAddress(model.getRequesterid());
        int friendPeerPort = dataBase.getPeerPort(model.getFriendid());
        String friendAddress = dataBase.getAddress(model.getFriendid());
        int friendid = model.getFriendid();
        String friendName = model.getFriendName();
        int requesterid = model.getRequesterid();
        String requesterName = model.getRequesterName();

        if (b1){
            dataBase.requestFriendbyID(model.getRequesterid(), model.getFriendid());
            output.success(model.getFriendid(), requesterAddress, requesterPeerPort);
            output.reportToFriend(friendid, requesterName, requesterid, friendAddress,friendPeerPort);
        }
        if (b2){
            dataBase.requestFriendbyName(model.getRequesterName(), model.getFriendName());
            output.success(model.getFriendid(), requesterAddress, requesterPeerPort);
            output.reportToFriend(friendid, requesterName, requesterid, friendAddress,friendPeerPort);
        }
        output.fail(model.getFriendid(), requesterAddress, requesterPeerPort);
    }
}
