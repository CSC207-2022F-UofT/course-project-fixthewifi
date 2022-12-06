package server.usecases.friendinteractors.requestfriend;


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
        boolean b1 = dataBase.ifexistsUID(model.getFriendid());
        boolean b2 = dataBase.ifexistsUserName(model.getFriendName());
        boolean b3 = dataBase.notAlreadyFriend(model.getRequesterid(), model.getFriendid());
        boolean b4 = dataBase.notAlreadyRequested(model.getRequesterid(), model.getFriendid());
        boolean b5 = model.getRequesterid() != model.getFriendid();
        dataBase.cleanRequesterListDuplicateUID(model.getRequesterid());

        if(b1 && b3 && b4 && b5){
            int requesterid = model.getRequesterid();
            int friendid = model.getFriendid();
            String requesterName = dataBase.getUserNamebyUID(requesterid);
            String requesterAddress = dataBase.getAddress(requesterid);
            int requesterPeerPort = dataBase.getPeerPort(requesterid);
            String friendAddress = dataBase.getAddress(friendid);
            int friendPeerPort = dataBase.getPeerPort(friendid);

            dataBase.requestFriendbyID(requesterid, friendid);
            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
            return;
        }
        if(b2 && b3 && b4 && b5){
            String requesterName = model.getRequesterName();
            String friendName = model.getFriendName();
            int friendid = dataBase.getUIDbyUserName(friendName);
            int requesterid = dataBase.getUIDbyUserName(requesterName);
            String requesterAddress = dataBase.getAddress(requesterid);
            int requesterPeerPort = dataBase.getPeerPort(requesterid);
            String friendAddress = dataBase.getAddress(friendid);
            int friendPeerPort = dataBase.getPeerPort(friendid);

            dataBase.requestFriendbyName(requesterName, friendName);
            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
            return;
        }
        // input not found in database
        int requesterid = model.getRequesterid();
        String requesterAddress = dataBase.getAddress(requesterid);
        int requesterPeerPort = dataBase.getPeerPort(requesterid);

        output.fail(requesterid, requesterAddress, requesterPeerPort);
    }
}
