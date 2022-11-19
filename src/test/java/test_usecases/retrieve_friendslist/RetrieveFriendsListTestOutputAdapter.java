package test_usecases.retrieve_friendslist;

import usecases.retrieve_friendslist.RetrieveFriendsListOutputBoundary;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

public class RetrieveFriendsListTestOutputAdapter implements RetrieveFriendsListOutputBoundary {
    RetrieveFriendsListOutputData output;
    @Override
    public void prepareView(RetrieveFriendsListOutputData output) {
        this.output = output;
    }
}
