package server.usecases.friendinteractors.acceptfriend;
import java.util.Arrays;
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
        String friendName = dataBase.getUserNamebyUID(friendid);
        int requesterPeerPort = dataBase.getPeerPort(requesterid);
        String requesterAddress = dataBase.getAddress(requesterid);
//        int friendPeerPort = dataBase.getPeerPort(friendid);
//        String friendAddress = dataBase.getAddress(friendid);
        String ifAccept = model.getIfAccept();
        dataBase.cleanRequesterListDuplicateUID(requesterid);
        dataBase.cleanRequesterListDuplicateUID(friendid);
        if(Objects.equals(ifAccept, "True")){
            dataBase.acceptFriendbyID(friendid, requesterid);

            String[] requesterData = dataBase.readUser(requesterid);
            String[] friendData = dataBase.readUser(friendid);

            String[] toRequester = Arrays.copyOfRange(friendData, 0, 5);
            toRequester[3] = toRequester[3].split("-")[0];

            String[] toFriend = Arrays.copyOfRange(requesterData, 0, 5);
            toFriend[3] = toFriend[3].split("-")[0];

            int chatUid = dataBase.createPrivateChat(requesterid, friendid);
            output.success(toRequester, requesterData[7], Integer.parseInt(requesterData[10]));
            output.success(toFriend, friendData[7], Integer.parseInt(friendData[10]));
            String[] chatInfo = dataBase.getChatInfo(chatUid);
            output.addUserToChat(chatInfo, friendid, requesterData[7], Integer.parseInt(requesterData[10]));
            output.addUserToChat(chatInfo, requesterid, friendData[7], Integer.parseInt(friendData[10]));
        }
        else{
            dataBase.refuseFriendbyID(friendid, requesterid);
            output.refuse(requesterid, friendid, friendName, requesterAddress, requesterPeerPort);
        }
    }
}