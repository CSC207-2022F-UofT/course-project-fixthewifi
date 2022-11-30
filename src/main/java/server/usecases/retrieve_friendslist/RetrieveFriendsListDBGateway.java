package server.usecases.retrieve_friendslist;

import server.entities.CommonUser;

import java.util.ArrayList;

public interface RetrieveFriendsListDBGateway {
    /**
     * retrieves
     * @param UID
     * @return
     */
    ArrayList<CommonUser> getFriendsListByUID(int UID);
}
