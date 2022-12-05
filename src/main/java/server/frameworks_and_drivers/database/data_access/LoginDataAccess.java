package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.register.RegisterDBGateWay;

public class LoginDataAccess implements RegisterDBGateWay
{
    Database database;

    public LoginDataAccess(Database database)
    {
        this.database = database;
    }


    @Override
    public int getNewUid(String username, String password)
    {
        return Database.returnNewUserUid();
    }

    @Override
    public void registerUser(int uid, String username, String password, String ipAddress)
    {
        database.newUser(uid, username, "", ipAddress, password);
    }
}
