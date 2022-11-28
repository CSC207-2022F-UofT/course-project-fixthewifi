package usecases.friendinteractors.deletefriend;


public class delete_friend_interactor implements delete_friend_input_boundary {
    final delete_friend_output_boundary output;
    final delete_friend_DSGateway dataBase;


    public delete_friend_interactor(delete_friend_DSGateway dataBase, delete_friend_output_boundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * find user by id name to delete friend. report success when input is found in database and fail when not found
     * @param model
     */

    @Override
    public void DeleteFriend(delete_friend_input_model model)
    {
        boolean bool1 = dataBase.findUserByUID(model.getFriendid());
        boolean bool2 = dataBase.findUserByName(model.getFriendName());
        int requesterPeerPort = dataBase.getPeerPort(model.getRequesterid());
        String requesterAddress = dataBase.getAddress(model.getRequesterid());
        int friendPeerPort = dataBase.getPeerPort(model.getFriendid());
        String friendAddress = dataBase.getAddress(model.getFriendid());
        int friendid = model.getFriendid();
        String friendName = dataBase.getUserName(friendid);
        int requesterid = model.getRequesterid();
        String requesterName = dataBase.getUserName(requesterid);

        if (bool1){
            dataBase.deleteFriendbyID(friendid, requesterid);
            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportSuccess(friendid, requesterid, requesterName, friendAddress,friendPeerPort);
        }
        if (bool2){
            dataBase.deleteFriendbyName(friendName, requesterName);
            output.success(requesterid, requesterAddress, requesterPeerPort);
            output.reportSuccess(friendid, requesterid, requesterName, friendAddress,friendPeerPort);
        }
        output.fail(requesterid, requesterAddress, requesterPeerPort);
    }
}
