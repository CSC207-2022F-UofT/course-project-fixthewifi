package server.frameworks_and_drivers.database;

import server.usecases.friendinteractors.acceptfriend.acceptFriendDSGateway;
import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;
import server.usecases.rating_changes.SendRatingDsGateway;
import server.usecases.register.RegisterDBGateWay;

public class DataAccess implements RegisterDBGateWay, 
                                    acceptFriendDSGateway, 
                                    requestFriendDSGateway,
                                    SendRatingDsGateway
{
    Database database;

    public DataAccess(Database database)
    {
        this.database = database;
    }


    @Override
    public void acceptFriendbyID(int friendid, int requesterid)
    {
    }

    @Override
    public void refuseFriendbyID(int friendid, int requesterid)
    {
    }

    @Override
    public String getuserName(int userid)
    {
        return database.readUser(userid, 1);
    }

    @Override
    public boolean findUserByUID(int uid)
    {
        return true;
    }

    @Override
    public boolean findUserByName(String name) {
        return true;
    }

    @Override
    public void requestFriendbyID(int requester, int friend)
    {
    }

    @Override
    public void requestFriendbyName(String requester, String friend)
    {
    }

    @Override
    public String getUserName(int uid)
    {
        return database.readUser(uid, 1);
    }

    @Override
    public int getUserid(String userName)
    {
        return 0;
    }

    @Override
    public String getAddress(int userid) {
        return database.readUser(userid, 7);
    }

    @Override
    public int getPeerPort(int userid)
    {
        return 4444;
    }

    @Override
    public int getNewUid(String username, String password) {
        return Database.returnNewUserUid();
    }

    @Override
    public void registerUser(int uid, String username, String password, String ipAddress)
    {
        database.newUser(uid, username, "", password, ipAddress);
    }


    @Override
    public void storeRating(int receiverUid, double avgRating) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public String userAddress(int identifier) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public int userPort(int identifier) {
        // TODO Auto-generated method stub
        return 0;
    }
}
