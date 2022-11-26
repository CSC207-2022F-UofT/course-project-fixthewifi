package client.frameworks_and_drivers.model;

import client.entities.*;

public class model
{
    private final FriendsList friendsList;
    private final UserProfile selfProfile;
    private final ChatList chatList;

    public model()
    {
        this.chatList = new ChatList();
        this.friendsList = new FriendsList();
        this.selfProfile = new UserProfile();
    }
}

