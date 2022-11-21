package test_usecases.retrieve_friendslist;

import entities.CommonUser;
import entities.FriendsList;
import entities.User;
import usecases.retrieve_friendslist.RetrieveFriendsListDBGateway;

import java.util.ArrayList;

/**
 * this is an implementation of RetrieveFriendsListDBGateway that is used for testing
 * RetrieveFriendsListInteractor.
 */
public class RetrieveFriendsListTestDatabase implements RetrieveFriendsListDBGateway {
    /**
     * this is the UID that the interactor used as an arguement on this database.
     * it is stored to test the correct UID is called.
     */
    int used_UID;
    ArrayList<CommonUser> friendslist;

    public RetrieveFriendsListTestDatabase(){
        this.friendslist = new ArrayList<CommonUser>();
    }

    /**
     *adds this user to the friendslist that will be returned
     */
    public void addUser(User user){
        this.friendslist.add((CommonUser) user);
    }
    @Override
    public ArrayList<CommonUser> getFriendsListByUID(int UID) {
        this.used_UID = UID;
        return this.friendslist;
    }
}
