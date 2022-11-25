package client.usecases.friendinteractors.addfriend;

import server.usecases.friendinteractors.addfriend.add_friend_input_model;

public interface AddFriendInputBoundary {
    public void AddFriend(add_friend_input_model model);
}
