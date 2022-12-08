package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.delete_account.DeleteDBGateWay;
import server.usecases.login.LoginDBGateWay;
import server.usecases.logout.LogoutDBGateWay;
import server.usecases.register.RegisterDBGateWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
This class implements the database gateway classes of the login, logout, register, and delete account
use cases and calls on database methods to do their work
 */

public class LoginDataAccess implements RegisterDBGateWay, LoginDBGateWay, LogoutDBGateWay, DeleteDBGateWay
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
    public boolean check(int UID, String password) {
        return Objects.equals(database.readUser(UID)[8], password);
    }

    @Override
    public String[] getUserProfile(int uid)
    {
        return database.readUser(uid);
    }

    @Override
    public ArrayList<String[]> getChats(int uid)
    {
        ArrayList<String[]> toReturn = new ArrayList<>();
        String[] chats = database.readUser(uid)[11].split("-");
        for (String chat : chats)
        {
            if (!chat.equals(""))
            {
                toReturn.add(database.readChat(Integer.parseInt(chat)));
            }
        }
        return toReturn;
    }

    @Override
    public ArrayList<String[]> getFriends(int uid)
    {
        ArrayList<String[]> toReturn = new ArrayList<>();
        String[] friends = database.readUser(uid)[6].split("-");
        for (String friend : friends)
        {
            if (!friend.equals(""))
            {
                toReturn.add(database.readUser(Integer.parseInt(friend)));
            }
        }
        return toReturn;
    }

    @Override
    public String userAddress(int uid) {
        try
        {
            return database.readUser(uid)[7];
        }
        catch (IndexOutOfBoundsException e)
        {
            return "-1";
        }
    }

    @Override
    public int userPort(int uid) {
        try
        {
            return Integer.parseInt(database.readUser(uid)[10]);
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }

    @Override
    public void setOnline(int uid) {
        database.updateUser(uid, 4, "T");
    }

    @Override
    public void logoutByUID(int uid) {
        database.updateUser(uid, 4, "F");
    }

    @Override
    public void deleteByUID(int uid) {
        String[] deleted = {String.valueOf(uid), "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED", "DELTETED"};
        database.updateUser(uid, deleted);
    }
}
