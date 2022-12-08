package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

public class DeleteEditMsgController implements DeleteEditMsgControllerInputBoundary{
    private final IfComManager comManager;
    private final Model model;
    private final String serverIp;

    public DeleteEditMsgController(IfComManager comManager, Model model, String serverIp) {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    public void deleteMsg(int msgUid, int chatUid){
        String date = new java.util.Date().toString();
        int senderUid = model.getSelfUid();
        String toDeleteMsg = 0+"#"+String.join(String.valueOf(Constants.SPR), String.valueOf(msgUid), String.valueOf(senderUid), String.valueOf(chatUid), date);
        comManager.send(serverIp, 4396, toDeleteMsg);

    }

    public void editMsg(String updatedContent, int msgUid, int chatUid){
        String date = new java.util.Date().toString();
        int senderUid = model.getSelfUid();
        String toEditMsg = 0+"#"+String.join(String.valueOf(Constants.SPR), String.valueOf(msgUid), String.valueOf(senderUid), String.valueOf(chatUid), updatedContent, date);
        comManager.send(serverIp, 4396, toEditMsg);

    }
}
