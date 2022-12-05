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

public class LoginOutputAdapter implements LoginOutputBoundary {
    final IfComManager comManager;
    private final char SPR = 30;
    public LoginOutputAdapter(IfComManager com){
        this.comManager = com;
    }
    @Override
    public void error(String message, String address, int userPort){
        comManager.send(address, userPort, message);
    }
    @Override
    public void ifSuccess(int uid, String[] userProfile, ArrayList<String[]> chatList, ArrayList<String[]> friendList, String address, int userPort){
        String friendProfile;
        String chatProfile;
        String selfProfile = Constants.LOGIN + "#" + 0 + SPR + String.join(String.valueOf(SPR), userProfile); //includes uid//
        comManager.send(address, userPort, selfProfile);
        for (int i = 0; i < friendList.size(); i ++){
            friendProfile = Constants.LOGIN + "#" + 1 + SPR + String.join(String.valueOf(SPR), friendList.get(i));
            comManager.send(address, userPort, friendProfile);
        }
        for (int i = 0; i < chatList.size(); i ++){
            chatProfile = Constants.LOGIN + "#" + 2 + SPR + String.join(String.valueOf(SPR), chatList.get(i));
            comManager.send(address, userPort, chatProfile);
        }
    }
}
