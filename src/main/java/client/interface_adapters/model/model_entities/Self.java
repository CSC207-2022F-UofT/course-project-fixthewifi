package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class Self extends User
{
    public final HashMap<Integer ,Chat> chatList;
    public final HashMap<Integer, Friend> friendList;

    public Self(int uid, UserProfile userProfile, HashMap<Integer, Chat> chatList, HashMap<Integer, Friend> friendList) {
        super(uid, userProfile);
        this.chatList = chatList;
        this.friendList = friendList;
    }
}
