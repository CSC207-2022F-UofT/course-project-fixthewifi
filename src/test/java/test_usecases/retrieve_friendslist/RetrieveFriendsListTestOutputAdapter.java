package test_usecases.retrieve_friendslist;

import usecases.retrieve_friendslist.RetrieveFriendsListOutputBoundary;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

/**
 * This is an implementation of RetrieveFreindsListOutputBoundary for
 * testing RetrieveFriendsListInteractor.
 */
public class RetrieveFriendsListTestOutputAdapter implements RetrieveFriendsListOutputBoundary {
    RetrieveFriendsListOutputData output;
    @Override
    public void prepareView(RetrieveFriendsListOutputData output) {
        this.output = output;
    }
}
