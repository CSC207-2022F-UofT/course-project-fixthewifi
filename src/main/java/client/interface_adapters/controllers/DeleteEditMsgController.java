package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;

public class DeleteEditMsgController implements DeleteEditMsgControllerInputBoundary{
    int serverport;
    private final IfComManager comManager;
    private final Model model;
    private final String serverIp;

    public DeleteEditMsgController(IfComManager comManager, Model model, String serverIp, int serverPort) {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverport = serverPort;

    }

    public void deleteMsg(String updatedContent){
        String chatUid = model.getPageState();
        String toDeleteMsg = Constants.DELETE_MSG+"#"+String.join(String.valueOf(Constants.SPR), chatUid, updatedContent);
        comManager.send(serverIp, 4396, toDeleteMsg);

    }

    public void editMsg(String updatedContent){
        String[] data = updatedContent.split(" ", 2);
        int msgUid = Integer.parseInt(data[0]);
        String chatUid = model.getPageState();
        int senderUid = model.getChat(Integer.parseInt(chatUid)).getMessages().get(msgUid).getSenderUid();
        String selfUid = String.valueOf(model.getSelfUid());
        String toEditMsg = Constants.EDIT_MSG+"#"+String.join(String.valueOf(Constants.SPR), chatUid, String.valueOf(msgUid), String.valueOf(senderUid), selfUid, data[1]);
        comManager.send(serverIp, 4396, toEditMsg);

    }
}
