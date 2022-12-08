package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.ModelInterface;
import server.frameworks_and_drivers.Constants;

public class FriendController implements FriendControllerInputBoundary
{
    private final IfComManager comManager;
    private final ModelInterface model;

    private final String serverIp;

    public FriendController(IfComManager comManager, ModelInterface model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    @Override
    public void requestFriend(int friendUid)
    {
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendUid + " " + selfUid;
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
        try{String toSend = Constants.DELETE_FRIEND + "#" + peerUid + " " + model.getSelfUid() + " " +
                model.findPrivateChat(peerUid);
            comManager.send(serverIp, 4396, toSend);}
        catch (Exception e){
            System.out.println("Delete friend failed"); // requires check if use view
        }
    }

    @Override
    public void viewFriend(int requesterid) {
        String toSend = Constants.VIEW_FRIEND + "#" + model.getSelfUid();
        comManager.send(serverIp, 4396, toSend);
    }
}
