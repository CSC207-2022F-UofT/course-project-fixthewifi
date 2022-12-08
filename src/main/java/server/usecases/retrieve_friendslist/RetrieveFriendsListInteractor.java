package server.usecases.retrieve_friendslist;

import server.entities.CommonUser;
import server.frameworks_and_drivers.Constants;

import java.util.ArrayList;

public class RetrieveFriendsListInteractor implements RetrieveFriendsListInputBoundary{
    private RetrieveFriendsListDBGateway database;
    private RetrieveFriendsListOutputBoundary output_adapter;

    public RetrieveFriendsListInteractor(
            RetrieveFriendsListDBGateway database, RetrieveFriendsListOutputBoundary output_adapter){
        this.output_adapter =  output_adapter;
        this.database = database;
    }

    @Override
    public void execute(RetrieveFriendsListInputData input) {
        int UID = input.getUID();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<CommonUser> friendslist = database.getFriendsListByUID(input.getUID());
        for(CommonUser u : friendslist){
            users.add(String.valueOf(u.getUid()) + Constants.SPR);
            //TODO: usernames.add(u.getUsername());
        }
        String peerID = database.getPeerIDFromUID(UID);
        int peer_port = database.getPeerPortFromUID(UID);
        RetrieveFriendsListOutputData output = new RetrieveFriendsListOutputData(
                UID, users, peer_port, peerID);
        output_adapter.prepareView(output);
    }
}
