package server.usecases.retrieve_friendslist;

import server.entities.User;

import java.util.ArrayList;

public interface RetrieveFriendsListDBGateway {
    /**
     * retrieves
     * @param UID
     * @return
     */
    ArrayList<User> getFriendsListByUID(int UID);
    /**
     * returns the PeerID associated with the active user with UID
     */
    String getPeerIDFromUID(int UID);
    /**
     * returns the PeerPort associated with the active user with UID
     */
    int getPeerPortFromUID(int UID);
}
