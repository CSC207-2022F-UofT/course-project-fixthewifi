package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;

public class RatingController implements RatingControllerInputBoundary
{
    int serverport;
    private final IfComManager comManager;
    private final Model model;
    char CONTENT_SPR = 30;
    private final String serverIp;
    
    public RatingController(IfComManager comManager, Model model, String serverIp, int serverPort)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverport = serverPort;

    }

    public void rate(int receiverUid, int rating)
    {
        String toSend = Constants.SEND_RATING + "#" + model.getSelfUid() + CONTENT_SPR + receiverUid + CONTENT_SPR + rating;
        // TO-DO: Change peerPort
        comManager.send(serverIp, 4396, toSend);
    }
}
