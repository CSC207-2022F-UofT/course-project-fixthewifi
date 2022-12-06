package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.friendinteractors.acceptfriend.acceptFriendDSGateway;
import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;

public class FriendDataAccess implements acceptFriendDSGateway, requestFriendDSGateway
{
    Database database;

    public FriendDataAccess(Database database)
    {
        this.database = database;
    }

    @Override
    public void acceptFriendbyID(int friendid, int requesterid) {

    }

    @Override
    public void refuseFriendbyID(int friendid, int requesterid) {

    }

    @Override
    public String getuserName(int userid) {
        return null;
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
    public void requestFriendbyID(int requester, int friend) {

    }

    @Override
    public void requestFriendbyName(String requester, String friend) {

    }

    @Override
    public String getUserName(int uid) {
        return null;
    }

    @Override
    public int getUserid(String userName) {
        return 0;
    }

    @Override
    public String getAddress(int userid) {
        return null;
    }

    @Override
    public int getPeerPort(int userid) {
        return 0;
    }
}
