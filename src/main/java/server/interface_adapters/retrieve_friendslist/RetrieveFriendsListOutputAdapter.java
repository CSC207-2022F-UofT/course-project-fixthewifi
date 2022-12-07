package server.interface_adapters.retrieve_friendslist;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.retrieve_friendslist.RetrieveFriendsListOutputBoundary;
import server.usecases.retrieve_friendslist.RetrieveFriendsListOutputData;


public class RetrieveFriendsListOutputAdapter implements RetrieveFriendsListOutputBoundary {
    private IfComManager comManager;
    public RetrieveFriendsListOutputAdapter(IfComManager comManager){this.comManager = comManager;}
    @Override
    public void prepareView(RetrieveFriendsListOutputData output) {
        String msg = String.valueOf(Constants.RETRIEVE_FREINDSLIST);
        for(String userdata : output.getUsers()){
            msg = msg + Constants.SPR + userdata;
        }
        comManager.send(output.getPeerID(), output.getPeer_port(), msg);
    }
}
