package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;

public class FriendController implements FriendControllerInputBoundary
{
    int serverport;

    private final IfComManager comManager;
    private final ModelInterface model;

    private final String serverIp;

    public FriendController(IfComManager comManager, ModelInterface model, String serverIp, int serverPort)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverport = serverPort;

    }

    @Override
    public void requestFriend(int friendUid)
    {
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendUid + " " + selfUid;
        comManager.send(serverIp, 4396, toSend);
    }

    public void requestFriend(String friendName){
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendName + " " + selfUid;
        comManager.send(serverIp, 4396, toSend);
    }

    public void acceptFriend(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " True";
        comManager.send(serverIp, 4396, toSend);
    }

    public void refuseFriend(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " False";
        comManager.send(serverIp, 4396, toSend);
    }

    public void deleteFriend(int peerUid){
        String toSend = Constants.DELETE_FRIEND + "#" + peerUid + " " + model.getSelfUid() + " " +
                model.findPrivateChat(peerUid);
        comManager.send(serverIp, 4396, toSend);
    }

    @Override
    public void viewFriend(int requesterid) {
        String toSend = Constants.VIEW_FRIEND + "#" + model.getSelfUid();
        comManager.send(serverIp, 4396, toSend);
    }
}
