//package server.frameworks_and_drivers.database;
//
//import server.usecases.friendinteractors.acceptfriend.acceptFriendDSGateway;
//import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;
//import server.usecases.profile_changes.ChangeProfileDsInputModel;
//import server.usecases.profile_changes.ChangeProfileGateWayDB;
//import server.usecases.register.RegisterDBGateWay;
//
//public class DataAccess implements RegisterDBGateWay, acceptFriendDSGateway, requestFriendDSGateway, ChangeProfileGateWayDB
//{
//    Database database;
//
//    public DataAccess(Database database)
//    {
//        this.database = database;
//    }
//
//
//    @Override
//    public void acceptFriendbyID(int friendid, int requesterid)
//    {
//    }
//
//    @Override
//    public void refuseFriendbyID(int friendid, int requesterid)
//    {
//    }
//
//    @Override
//    public String getuserName(int userid)
//    {
//        return database.readUser(userid, 1);
//    }
//
//    @Override
//    public boolean findUserByUID(int uid)
//    {
//        return true;
//    }
//
//    @Override
//    public boolean findUserByName(String name) {
//        return true;
//    }
//
//    @Override
//    public void requestFriendbyID(int requester, int friend)
//    {
//    }
//
//    @Override
//    public void requestFriendbyName(String requester, String friend)
//    {
//    }
//
//    @Override
//    public String getUserName(int uid)
//    {
//        return database.readUser(uid, 1);
//    }
//
//    @Override
//    public int getUserid(String userName)
//    {
//        return 0;
//    }
//
//    @Override
//    public String getAddress(int userid) {
//        return database.readUser(userid, 7);
//    }
//
//    @Override
//    public int getPeerPort(int userid)
//    {
//        return 4444;
//    }
//
//    @Override
//    public int getNewUid(String username, String password) {
//        return Database.returnNewUserUid();
//    }
//
//    @Override
//    public void registerUser(int uid, String username, String password, String ipAddress)
//    {
//        database.newUser(uid, username, "", password, ipAddress);
//    }
//
//    @Override
//    public String userAdress(int identifier) {
//        return getAddress(identifier);
//    }
//
//    @Override
//    public int userPort(int identifier) {
//        return 0;
//    }
//
//    @Override
//    public boolean existsByUID(int identifier) {
//        return true;
//    }
//
//    @Override
//    public void storeSetPic(ChangeProfileDsInputModel dbModel) {
//
//    }
//
//    @Override
//    public void storeDelPic(ChangeProfileDsInputModel dbModel) {
//
//    }
//
//    @Override
//    public void storeUpdateName(ChangeProfileDsInputModel dbModel) {
//
//    }
//
//    @Override
//    public void storeUpdateDescr(ChangeProfileDsInputModel dbModel) {
//
//    }
//}
