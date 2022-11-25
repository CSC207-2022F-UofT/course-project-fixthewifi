package usecases.friendinteractors.acceptfriend;

public class acceptFriendInteractor implements acceptFriendInputBoundary {
    final acceptFriendOutputBoundary output;
    final acceptFriendDSGateway dataBase;


    public acceptFriendInteractor(acceptFriendDSGateway dataBase, acceptFriendOutputBoundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void acceptFriend(acceptFriendInputModel model) {
        boolean bool1 = dataBase.findUserByUID(model.getFriendid());
        boolean bool2 = dataBase.findUserByName(model.getFriendName());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());

        if (bool1){
            dataBase.acceptFriendbyID(model.getFriendid(), model.getRequesterid());
            output.success(model.getRequesterid(), address, peerPort);
        }
        if (bool2){
            dataBase.acceptFriendbyName(model.getFriendName(), model.getRequesterName());
            output.success(model.getRequesterid(), address, peerPort);
        }
        output.fail(model.getRequesterid(), address, peerPort);
    }
}
