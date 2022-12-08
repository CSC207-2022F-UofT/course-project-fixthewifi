package server.interface_adapters.login;
import client.frameworks_and_drivers.Constants;
import server.usecases.login.*;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import java.util.*;

/*
for the information sent to the client
0 means self profile
1 means friend's profile
2 means chat's profile and messages
 */

public class LoginOutputAdapter implements LoginOutputBoundary
{
    private final IfComManager comManager;
    private final char SPR = 30;
    public LoginOutputAdapter(IfComManager com)
    {
        this.comManager = com;
    }

    @Override
    public void sendSelfProfile(String[] userProfile, String address, int userPort)
    {
        String content = 3 + "#" + 0 + " " + String.join(String.valueOf(SPR), userProfile);
        comManager.send(address, userPort, content);

    }

    @Override
    public void sendFriend(String[] friend, String address, int userPort)
    {
        String content = 3 + "#" + 1 + " " + String.join(String.valueOf(SPR), friend);
        comManager.send(address, userPort, content);
    }

    @Override
    public void sendChat(String[] chat, String address, int userPort)
    {
        String content = 3 + "#" + 2 + " " + String.join(String.valueOf(SPR), chat);
        comManager.send(address, userPort, content);

    }

    public void sendUser(int chatUid, int adminUid, String[] chat, String address, int userPort)
    {
        String content = 3 + "#" + 3 + " " + String.join(String.valueOf(SPR), chat) + SPR + chatUid + SPR + adminUid;
        comManager.send(address, userPort, content);

    }

    @Override
    public void error(String message, String address, int userPort){
        comManager.send(address, userPort, message);
    }

    }
