package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;

public class SendMsgController implements SendMsgControllerInputBoundary
{
    private final int serverPort;
    private final IfComManager comManager;
    private final Model model;
    private final String serverIp;


    public SendMsgController(IfComManager comManager, Model model, String serverIp, int serverPort)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverPort = serverPort;

    }

    public void sendMsg(String content, int chatUid)
    {
        String date = new java.util.Date().toString();
        int senderUid = model.getSelfUid();
        String toSend = 0+"#"+String.join(String.valueOf(Constants.SPR), String.valueOf(senderUid), String.valueOf(chatUid), content, date);
        comManager.send(serverIp,serverPort, toSend);
    }
}
