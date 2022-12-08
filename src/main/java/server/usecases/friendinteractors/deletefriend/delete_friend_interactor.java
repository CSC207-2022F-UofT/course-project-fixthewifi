package server.usecases.friendinteractors.deletefriend;


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
        boolean bool1 = dataBase.ifexistsUID(model.getFriendid());
        boolean bool2 = dataBase.ifexistsUserName(model.getFriendName());
        int requesterPeerPort = dataBase.getPeerPort(model.getRequesterid());
        String requesterAddress = dataBase.getAddress(model.getRequesterid());
        int requesterid = model.getRequesterid();
        String requesterName = dataBase.getUserNamebyUID(requesterid);
        int chatUid = model.getChatUid();

        if (bool1){
            int friendPeerPort = dataBase.getPeerPort(model.getFriendid());
            String friendAddress = dataBase.getAddress(model.getFriendid());
            int friendid = model.getFriendid();
//            String friendName = dataBase.getUserNamebyUID(friendid);
            dataBase.deleteFriendbyID(friendid, requesterid);
            dataBase.deleteChat(chatUid);
            output.success(friendid, requesterAddress, requesterPeerPort);
            output.success(requesterid, friendAddress, friendPeerPort);
//            output.reportSuccess(friendid, requesterid, requesterName, friendAddress,friendPeerPort);
            return;
        } else if (bool2){
            int friendid = dataBase.getUIDbyUserName(model.getFriendName());
            int friendPeerPort = dataBase.getPeerPort(model.getFriendid());
            String friendAddress = dataBase.getAddress(friendid);
            String friendName = dataBase.getUserNamebyUID(friendid);
            dataBase.deleteFriendbyName(friendName, requesterName);
            output.success(friendid, requesterAddress, requesterPeerPort);
            output.success(requesterid, friendAddress, friendPeerPort);
            //output.reportSuccess(friendid, requesterid, requesterName, friendAddress,friendPeerPort);
            return;
        }
        else
        {
            output.fail(requesterid, requesterAddress, requesterPeerPort);
            return;
        }
    }
}
