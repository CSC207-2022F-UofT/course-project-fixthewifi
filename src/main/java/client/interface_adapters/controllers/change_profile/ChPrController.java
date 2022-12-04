package client.interface_adapters.controllers.change_profile;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

public class ChPrController implements ChPrControllerInputBoundary {

    int serverport = 4396;
    private final IfComManager comManager;
    private final Model model;

    char CONTENT_SPR = Constants.SPR;
    char HASH ='#';
    private final String serverIp;

    public ChPrController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    @Override
    public void setPic(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(server.frameworks_and_drivers.Constants.SET_PIC + HASH + selfUid
                +
                CONTENT_SPR+""
                + CONTENT_SPR+""
                +CONTENT_SPR + content);

        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void delPic(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(server.frameworks_and_drivers.Constants.DEL_PIC + HASH + selfUid
                +
                CONTENT_SPR+""
                + CONTENT_SPR+""
                +CONTENT_SPR + content);

        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void updateName(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(server.frameworks_and_drivers.Constants.UPDATE_NAME + HASH + selfUid
                + CONTENT_SPR + content+
                 CONTENT_SPR+""+ CONTENT_SPR+"");
        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void updateDescr(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(server.frameworks_and_drivers.Constants.UPDATE_DESC + HASH + selfUid
                +
                CONTENT_SPR+""
                +CONTENT_SPR + content+ CONTENT_SPR+"");

        comManager.send(serverIp, serverport, toSend);
    }
}
