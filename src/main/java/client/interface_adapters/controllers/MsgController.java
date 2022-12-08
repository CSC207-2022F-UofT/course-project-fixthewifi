package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

public class MsgController implements MsgControllerInputBoundary
{
    private final IfComManager comManager;
    private final Model model;
    private final String serverIp;


    public MsgController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    public void sendMsg(String content, int chatUid)
    {
        String date = new java.util.Date().toString();
        int senderUid = model.getSelfUid();
        String toSend = 0+"#"+String.join(String.valueOf(Constants.SPR), String.valueOf(senderUid), String.valueOf(chatUid), content, date);
        comManager.send(serverIp,4396, toSend);
    }
}
