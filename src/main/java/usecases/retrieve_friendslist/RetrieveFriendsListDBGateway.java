package usecases.retrieve_friendslist;

import entities.CommonUser;
import entities.FriendsList;

import java.util.ArrayList;

public interface RetrieveFriendsListDBGateway {
    /**
     * retrieves
     * @param UID
     * @return
     */
    ArrayList<CommonUser> getFriendsListByUID(int UID);
}
