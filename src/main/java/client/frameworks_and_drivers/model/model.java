package client.frameworks_and_drivers.model;

import client.entities.*;

public class model
{
    private final FriendsList friendsList;
    private final UserProfile selfProfile;

    private final ChatList chat;

    public model()
    {
        this.chat = new ChatList();
        this.friendsList = new FriendsList();
        this.selfProfile = new UserProfile();
    }
}

