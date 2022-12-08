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
        if (model.getFriendid() == -1){
            int requesterid = model.getRequesterid();
            String friendName = model.getFriendName();
            boolean b2 = dataBase.ifexistsUserName(friendName);
            if (b2){
                int friendid = dataBase.getUIDbyUserName(model.getFriendName());
                boolean b3 = dataBase.notAlreadyFriend(requesterid, friendid);
                boolean b4 = dataBase.notAlreadyRequested(requesterid, friendid);
                boolean b5 = model.getRequesterid() != model.getFriendid();

                String requesterAddress = dataBase.getAddress(requesterid);
                int requesterPeerPort = dataBase.getPeerPort(requesterid);
                String friendAddress = dataBase.getAddress(friendid);
                int friendPeerPort = dataBase.getPeerPort(friendid);

                String requesterName = dataBase.getUserNamebyUID(requesterid);

                if (b3 && b4 && b5) {
                    dataBase.requestFriendbyName(requesterName, friendName);
                    output.success(requesterid, requesterAddress, requesterPeerPort);
                    output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
                    return;
                }
            }
        }else if (model.getFriendid() != -1){
            int friendid = model.getFriendid();
            int requesterid = model.getRequesterid();
            if (dataBase.ifexistsUID(friendid)) {
                String friendName = dataBase.getUserNamebyUID(friendid);
                String requesterName = dataBase.getUserNamebyUID(requesterid);

                String requesterAddress = dataBase.getAddress(requesterid);
                int requesterPeerPort = dataBase.getPeerPort(requesterid);
                String friendAddress = dataBase.getAddress(friendid);
                int friendPeerPort = dataBase.getPeerPort(friendid);

                boolean b3 = dataBase.notAlreadyFriend(requesterid, friendid);
                boolean b4 = dataBase.notAlreadyRequested(requesterid, friendid);
                boolean b5 = model.getRequesterid() != model.getFriendid();

                if (b3 && b4 && b5) {
                    dataBase.requestFriendbyName(requesterName, friendName);
                    output.success(requesterid, requesterAddress, requesterPeerPort);
                    output.reportToFriend(requesterid, requesterName, friendid, friendAddress, friendPeerPort);
                }
            }
        }
        // input not found in database
        int requesterid = model.getRequesterid();
        String requesterAddress = dataBase.getAddress(requesterid);
        int requesterPeerPort = dataBase.getPeerPort(requesterid);

        output.fail(requesterid, requesterAddress, requesterPeerPort);
    }
}
