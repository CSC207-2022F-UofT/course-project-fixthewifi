package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import server.frameworks_and_drivers.Constants;

public class FriendController implements FriendControllerInputBoundary
{
    private final IfComManager comManager;
    private final Model model;

    private final String serverIp;

    public FriendController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    @Override
    public void request(int friendUid)
    {
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendUid + " " + selfUid;
        comManager.send(serverIp, 4396, toSend);
    }

    public void accept(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " True";
        comManager.send(serverIp, 4396, toSend);
    }

    public void refuse(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " False";
        comManager.send(serverIp, 4396, toSend);
    }
}
