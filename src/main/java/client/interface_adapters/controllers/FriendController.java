package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;
import client.interface_adapters.presenters.FriendPresenter;
import client.frameworks_and_drivers.view.console_view.ConsoleView;

/**
 * This is a controller for Friend features including request friend, accept and reject friend, and delete friend
 */
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

    /**
     * It takes friend`s ID to try to request friend
     * @param friendUid
     */
    @Override
    public void requestFriend(int friendUid)
    {
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendUid + " " + selfUid;
        comManager.send(serverIp, 4396, toSend);
    }

    /**
     * It takes friend`s name to request a friend
     * @param friendName
     */
    public void requestFriend(String friendName){
        int selfUid = model.getSelfUid();
        String toSend = Constants.REQUEST_FRIEND + "#" + friendName + " " + selfUid;
        comManager.send(serverIp, 4396, toSend);
    }

    /**
     * It takes requester`s ID to accept the requester as the friend, action from friend side
     * @param peerUid
     */
    public void acceptFriend(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " True";
        comManager.send(serverIp, 4396, toSend);
    }

    /**
     * It takes requester`s ID to reject the requester as the friend, action from friend side
     * @param peerUid
     */
    public void refuseFriend(int peerUid)
    {
        String toSend = Constants.ACCEPT_FRIEND + "#" + model.getSelfUid() + " " + peerUid + " False";
        comManager.send(serverIp, 4396, toSend);
    }

    /**
     * It takes user`s ID to delete the user2 as the friend, action from either side. As long as they are friend
     * Noticed that an error shows up if entering a wrong user id
     * @param peerUid
     */
    public void deleteFriend(int peerUid){
        try{
            String toSend = Constants.DELETE_FRIEND + "#" + peerUid + " " + model.getSelfUid() + " " +
                    model.findPrivateChat(peerUid);
            comManager.send(serverIp, 4396, toSend);
        }catch (Exception e){
            System.out.println("Fail to delete friend. You any entered a wrong user ID.");
        }
    }


    /**
     * To return friend list
     * @param requesterid
     */
    @Override
    public void viewFriend(int requesterid) {
        String toSend = Constants.VIEW_FRIEND + "#" + model.getSelfUid();
        comManager.send(serverIp, 4396, toSend);
    }
}
