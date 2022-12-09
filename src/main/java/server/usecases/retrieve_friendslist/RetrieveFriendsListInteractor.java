package server.usecases.retrieve_friendslist;

import server.entities.User;
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
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<User> friendslist = database.getFriendsListByUID(input.getUID());
        for(User u : friendslist){
            String s = u.getUid() + Constants.SPR + u.getName();
            usernames.add(s);
        }
        String peerID = database.getPeerIDFromUID(UID);
        int peer_port = database.getPeerPortFromUID(UID);
        RetrieveFriendsListOutputData output = new RetrieveFriendsListOutputData(
                UID, usernames, peer_port, peerID);
        output_adapter.prepareView(output);
    }
}
