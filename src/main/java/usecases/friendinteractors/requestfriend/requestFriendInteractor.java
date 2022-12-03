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
    public void RequestFriend(requestFriendInputModel model) {
        boolean b1 = dataBase.findUserByUID(model.getFriendid());
        boolean b2 = dataBase.findUserByName(model.getFriendName());
        if(b1){
            int requesterid = model.getRequesterid();
            int friendid = model.getFriendid();
            String requesterName = dataBase.getUserName(requesterid);
            String requesterAddress = dataBase.getAddress(requesterid);
            int requesterPeerPort = dataBase.getPeerPort(requesterid);
            String friendAddress = dataBase.getAddress(friendid);
            int friendPeerPort = dataBase.getPeerPort(friendid);

            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
        }
        if(b2){
            String requesterName = model.getRequesterName();
            String friendName = model.getFriendName();
            int friendid = dataBase.getUserNamebyUID(friendName);
            int requesterid = dataBase.getUserNamebyUID(requesterName);
            String requesterAddress = dataBase.getAddress(requesterid);
            int requesterPeerPort = dataBase.getPeerPort(requesterid);
            String friendAddress = dataBase.getAddress(friendid);
            int friendPeerPort = dataBase.getPeerPort(friendid);

            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
        }
        // input not found in database
        int requesterid = model.getRequesterid();
        String requesterAddress = dataBase.getAddress(requesterid);
        int requesterPeerPort = dataBase.getPeerPort(requesterid);

        output.fail(requesterid, requesterAddress, requesterPeerPort);
    }
}
