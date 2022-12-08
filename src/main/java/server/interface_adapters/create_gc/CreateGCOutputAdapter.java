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
     *
     * String contains Constants.GROUP_CHAT, the admins UID, every members UID,
     * in that order separated by Constants.SPR
     */
    @Override
    public void prepareSuccessView(CreateGCOutputData output_data) {
        String peer_id = output_data.getPeerID();
        int peer_port = output_data.getPeerPort();
        String msg = String.valueOf(Constants.GROUP_CHAT);
        msg = msg + Constants.SPR + String.valueOf(output_data.getAdmin());
        for (int x : output_data.getMembers()){
            msg = msg + Constants.SPR + x;
        }
        comManager.send(peer_id, peer_port, msg);
    }
}
