package client.usecases.retrieve_friendslist;

import server.usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

public interface RetrieveFriendsListOutputBoundary {
    void prepareView(RetrieveFriendsListOutputData output);
}
