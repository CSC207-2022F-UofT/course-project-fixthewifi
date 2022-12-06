package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.logout.LogoutDBGateWay;
import server.usecases.register.RegisterDBGateWay;

public class LoginDataAccess implements RegisterDBGateWay, LogoutDBGateWay
{
    Database database;

    public LoginDataAccess(Database database)
    {
        this.database = database;
    }


    @Override
    public int getNewUid(String username, String password)
    {
        return database.returnNewUserUid();
    }

    @Override
    public void registerUser(int uid, String username, String password, String ipAddress)
    {
        database.newUser(uid, username, "", ipAddress, password, 4444);
    }

    @Override
    public void logoutByUID(int uid) {
        database.updateUser(uid, 4, "F");
    }
}
