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
}
