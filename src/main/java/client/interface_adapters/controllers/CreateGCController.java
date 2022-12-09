package client.interface_adapters.controllers;

import client.frameworks_and_drivers.Constants;
import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import java.util.Objects;

/**
 * Client Side controller for the CreateGC and RetrieveFriendsList usecases.
 * Parses information for the client side ComManger to send to the server side ComManager.
 */
public class CreateGCController implements CreateGCControllerInputBoundary {
    private final IfComManager comManager;
    private final Model model;

    private final String serverIp;

    public CreateGCController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
    }

    /**
     * Creates a String (msg) then has ComManager send that message to the server.
     * (msg) contains Constants.RETRIEVE_FRIENDS_LIST and the users UID.
     */
    @Override
    public void getList() {
        String UID = String.valueOf(model.getSelfUid());
        String msg = Constants.RETRIEVE_FRIENDS_LIST + "#" + UID;
        comManager.send(this.serverIp, 4396, msg);
    }

    /**
     * Creates a String (msg) then has ComManager send that message to the server.
     * (msg) contains Constants.CREATE_GROUP_CHAT, admins UID, then all the other members UIDs
     * @param users String of non-admin users UIDs, separated by commas.
     */
    @Override
    public void create(String users) {
        String[] ids = users.split(", ");
        String msg = Constants.GROUP_CHAT + "#" ;
        msg = msg + String.valueOf(model.getSelfUid()) + Constants.SPR;
        for(String x : ids){
            if(!Objects.equals(x, ids[0]))
                msg = msg + Constants.SPR;
            msg = msg + x;
        }
        comManager.send(this.serverIp, 4396, msg);
    }
}
