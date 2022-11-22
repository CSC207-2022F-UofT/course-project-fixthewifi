package interface_adapters.friend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import frameworks_and_drivers.communication_manager.ComManagerUser;
import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.send_chat.SendChatOutputModel;


public class ViewFriendOutputAdapater
{
    private final IfComManager comManager;
    public ViewFriendOutputAdapater(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    public void pushFriendList(List<String> list, String address, int peerPort)
    {
        String content = list.toString();
        comManager.send(address, peerPort, content);
    }
}
