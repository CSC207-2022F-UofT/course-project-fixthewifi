package server.interface_adapters.create_gc;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.create_gc.CreateGCOutputBoundary;
import server.usecases.create_gc.CreateGCOutputData;


public class CreateGCOutputAdapter implements CreateGCOutputBoundary {
    private IfComManager comManager;
    public CreateGCOutputAdapter(IfComManager comManager){ this.comManager = comManager;}
    /**
     * parses the CreateGCOutputData for a IfComManager.
     * String contains Constants.GROUP_CHAT, chat_uid,  admins UID, every other members UID,
     * in that order separated by Constants.SPR
     */
    @Override
    public void prepareSuccessView(CreateGCOutputData output_data) {
        String peer_id = output_data.getUser_peerID();
        int peer_port = output_data.getUser_peerPort();
        String msg = Constants.GROUP_CHAT + "#";
        msg = msg + output_data.getChat_uid();
        msg = msg + Constants.SPR + output_data.getAdmin_uid();
        for (int x : output_data.getMembers_Uids()){
            msg = msg + Constants.SPR + x;
        }
        comManager.send(peer_id, peer_port, msg);
    }
}
