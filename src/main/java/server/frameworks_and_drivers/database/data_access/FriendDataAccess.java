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

        // Take out friends, add new friend
        List<String> friendList = new LinkedList<>(Arrays.asList(friend[6].split("-")));
        friendList.add(String.valueOf(requesterid));

        // Take out requesters and remove the person that just became friend
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));
        requesterList.remove(String.valueOf(requesterid));

        //store back to database
        friend[6] = String.join("-", friendList.toArray(new String[0]));
        friend[9] = String.join("-", requesterList.toArray(new String[0]));
        database.updateUser(friendid, friend);

        // Take out the row of information that belongs to requesterid
        String[] requester = database.readUser(requesterid);

        // Take out friends, add new friend
        List<String> friendList1 = new LinkedList<>(Arrays.asList(friend[6].split("-")));
        friendList1.add(String.valueOf(requesterid));

        //store back to database
        requester[6] = String.join("-", friendList1.toArray(new String[0]));
        database.updateUser(requesterid, requester);
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
        return Integer.parseInt(database.readUser(uid)[10]);
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

        // Take out requesters, add the new requester
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));
        requesterList.add(String.valueOf(requesterid));

        // Store back to database.
        friend[9] = String.join("-", requesterList.toArray(new String[0]));
        database.updateUser(friendid, friend);
    }

    @Override
    public void requestFriendbyName(String requester, String friend) {

    }
}
