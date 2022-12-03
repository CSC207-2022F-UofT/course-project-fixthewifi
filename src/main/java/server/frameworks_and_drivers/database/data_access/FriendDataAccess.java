package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.friendinteractors.acceptfriend.acceptFriendDSGateway;
import server.usecases.friendinteractors.deletefriend.delete_friend_DSGateway;
import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FriendDataAccess implements acceptFriendDSGateway, requestFriendDSGateway, delete_friend_DSGateway
{
    Database database;

    public FriendDataAccess(Database database)
    {
        this.database = database;
    }


    @Override
    public void acceptFriendbyID(int friendid, int requesterid)
    {
        // Take out the row of information that belongs to friendid
        String[] friend = database.readUser(friendid);

        // Take out friends
        List<String> friendList = Arrays.asList(friend[6].split("-"));
        friendList.add(String.valueOf(requesterid));

        // Take out requesters
        List<String> requesterList = Arrays.asList(friend[8].split("-"));
        requesterList.remove(String.valueOf(requesterid));

        String[] newFriend = {friend[0], friend[1],
                friend[2], friend[3],
                friend[4], friend[5],
                String.join("-", friendList.toArray(new String[0])),
                friend[7],
                String.join("-", requesterList.toArray(new String[0]))};
        database.updateUser(friendid, newFriend);


        String[] requester = database.readUser(requesterid);
        List<String> friendList1 = Arrays.asList(requester[6].split("-"));
        friendList1.add(String.valueOf(requesterid));

        String[] newRequester = {requester[0], requester[1],
                requester[2], requester[3],
                requester[4], requester[5],
                String.join("-", friendList1.toArray(new String[0])),
                requester[7],
                requester[8]};
        database.updateUser(requesterid, newRequester);
    }



    @Override
    public void refuseFriendbyID(int friendid, int requesterid) {

    }

    @Override
    public void deleteFriendbyID(int user1, int user2) {

    }

    @Override
    public void deleteFriendbyName(String user1, String user2) {

    }

    @Override
    public int getUIDbyUserName(String userName) {
        return 0;
    }

    @Override
    public String getUserNamebyUID(int uid) {
        return database.readUser(uid)[1];
    }

    @Override
    public String getAddress(int uid) {
        return database.readUser(uid)[7];
    }

    @Override
    public int getPeerPort(int uid) {
        return 4444;
    }

    @Override
    public boolean ifexistsUserName(String userName) {
        return false;
    }

    @Override
    public boolean ifexistsUID(int uid) {
        return true;
    }

    @Override
    public boolean findUserByUID(int uid) {
        return false;
    }

    @Override
    public boolean findUserByName(String name) {
        return false;
    }

    @Override
    public void requestFriendbyID(int requesterid, int friendid)
    {
        // Take out the row of information that belongs to friendid
        String[] friend = database.readUser(friendid);

        // Take out requesters
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));

        String toadd = String.valueOf(requesterid);
        requesterList.add(toadd);
        String[] newFriend = {friend[0], friend[1],
                friend[2], friend[3],
                friend[4], friend[5],
                friend[6], friend[7], friend[8],
                String.join("-", requesterList.toArray(new String[0])),
                friend[10]};

        database.updateUser(friendid, newFriend);
    }

    @Override
    public void requestFriendbyName(String requester, String friend) {

    }
}
