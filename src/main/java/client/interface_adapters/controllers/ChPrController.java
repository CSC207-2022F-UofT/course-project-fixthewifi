package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;
import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;

public class ChPrController implements ChPrControllerInputBoundary {

    int serverport;
    private final IfComManager comManager;
    private final Model model;

    char CONTENT_SPR = Constants.SPR;
    String HASH ="#";
    private final String serverIp;

    public ChPrController(IfComManager comManager, Model model, String serverIp, int serverPort)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverport = serverPort;
    }

    @Override
    public void setPic(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(Constants.SET_PIC + HASH + selfUid
                +
                CONTENT_SPR+"DONTCHANGE"
                + CONTENT_SPR+"DONTCHANGE"
                +CONTENT_SPR + content);

        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void delPic() {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(Constants.DEL_PIC + HASH + selfUid
                +
                CONTENT_SPR+"DONTCHANGE"
                + CONTENT_SPR+"DONTCHANGE"
                +CONTENT_SPR + "DELETED");

        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void updateName(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(Constants.UPDATE_NAME + HASH + selfUid
                + CONTENT_SPR + content+
                 CONTENT_SPR+"DONTCHANGE"+ CONTENT_SPR+"DONTCHANGE");
        comManager.send(serverIp, serverport, toSend);
    }

    @Override
    public void updateDescr(String content) {
        int selfUid = model.getSelfUid();
        String toSend = String.valueOf(Constants.UPDATE_DESC + HASH + selfUid
                +
                CONTENT_SPR+"DONTCHANGE"
                +CONTENT_SPR + content+ CONTENT_SPR+"DONTCHANGE");

        comManager.send(serverIp, serverport, toSend);
    }
}
