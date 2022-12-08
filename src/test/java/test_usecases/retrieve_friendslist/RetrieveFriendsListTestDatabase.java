package test_usecases.retrieve_friendslist;

import server.entities.User;
import server.entities.User;
import server.usecases.retrieve_friendslist.RetrieveFriendsListDBGateway;

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
    ArrayList<User> friendslist;

    public RetrieveFriendsListTestDatabase(){
        this.friendslist = new ArrayList<User>();
    }

    /**
     *adds this user to the friendslist that will be returned
     */
    public void addUser(User user){
        this.friendslist.add((User) user);
    }
    @Override
    public ArrayList<User> getFriendsListByUID(int UID) {
        this.used_UID = UID;
        return this.friendslist;
    }
}
