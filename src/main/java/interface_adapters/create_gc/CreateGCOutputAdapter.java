package interface_adapters.create_gc;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputBoundary;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

public class CreateGCOutputAdapter implements RetrieveFriendsListOutputBoundary {
    private IfComManager comManager;
    @Override
    public void prepareView(RetrieveFriendsListOutputData output) {
        // get PeerIP and peerPort from database
    }
}
