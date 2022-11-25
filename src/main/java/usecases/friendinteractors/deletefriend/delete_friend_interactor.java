package usecases.friendinteractors.deletefriend;


public class delete_friend_interactor implements delete_friend_input_boundary {
    final delete_friend_output_boundary output;
    final delete_friend_DSGateway dataBase;


    public delete_friend_interactor(delete_friend_DSGateway dataBase, delete_friend_output_boundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void DeleteFriend(delete_friend_input_model model)
    {
        boolean bool1 = dataBase.findUserByUID(model.getFriendid());
        boolean bool2 = dataBase.findUserByName(model.getFriendName());
        int peerPort = dataBase.getPeerPort(model.getRequesterid());
        String address = dataBase.getAddress(model.getRequesterid());
        if (bool1){
            dataBase.deleteFriendbyID(model.getFriendid(), model.getRequesterid());
            output.success(model.getRequesterid(), address, peerPort);
        }
        if (bool2){
            dataBase.deleteFriendbyName(model.getFriendName(), model.getRequesterName());
            output.success(model.getRequesterid(), address, peerPort);
        }
        output.fail(model.getRequesterid(), address, peerPort);
    }
}
