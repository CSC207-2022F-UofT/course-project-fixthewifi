package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import server.frameworks_and_drivers.Constants;

public class RatingController implements RatingControllerInputBoundary
{
    // Change peerPort value as neccessary
    private final IfComManager comManager;
    private final Model model;
    char CONTENT_SPR = 30;
    private final String serverIp;
    private final int peerPort = 4396;
    
    public RatingController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    public void rate(int receiverUid, int rating)
    {
        String toSend = Constants.SEND_RATING + "#" + model.getSelfUid() + CONTENT_SPR + receiverUid + CONTENT_SPR + rating;
        comManager.send(serverIp, peerPort, toSend);
    }
}
