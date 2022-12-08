package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.interface_adapters.delete_account.DeleteController;
import server.usecases.delete_account.DeleteDBGateWay;
import server.usecases.logout.LogoutDBGateWay;
import server.usecases.register.RegisterDBGateWay;

/*
This class implements the database gateway classes of the login, logout, register, and delete account
use cases and calls on database methods to implement the job they are supposed to do.
 */

public class LoginDataAccess implements RegisterDBGateWay, LogoutDBGateWay, DeleteDBGateWay
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
    public void registerUser(int uid, String username, String password, String ipAddress, int port)
    {
        database.newUser(uid, username, "", ipAddress, password, port);
    }

    @Override
    public void logoutByUID(int uid) {
        database.updateUser(uid, 4, "F");
    }

    @Override
    public void deleteByUID(int uid) {
        String[] deleted = {String.valueOf(uid), "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED"};
        database.updateUser(uid, deleted);
    }
}
