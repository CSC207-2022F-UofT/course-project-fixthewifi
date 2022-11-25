package client.usecases.retrieve_friendslist;

import server.usecases.retrieve_friendslist.RetrieveFriendsListInputData;

public interface RetrieveFriendsListInputBoundary {
    void execute(RetrieveFriendsListInputData input);
}
