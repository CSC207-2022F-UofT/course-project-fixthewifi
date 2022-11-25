package client.usecases.friendinteractors.deletefriend;

import server.usecases.friendinteractors.deletefriend.delete_friend_input_model;

public interface delete_friend_input_boundary {
    public void DeleteFriend(delete_friend_input_model model);
}
