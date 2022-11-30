package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class Self implements User
{
    private int uid;
    public final UserProfile userProfile;
    public final HashMap<Integer ,Chat> chatList;
    public final HashMap<Integer, Friend> friendList;

    public Self()
    {
        uid = 4396;
        userProfile = new UserProfile();
        chatList = new HashMap<>();
        friendList = new HashMap<>();
    }

    public int getUid()
    {
        return uid;
    }

    public String getStatus()
    {
        return userProfile.getStatus();
    }


    public Chat getChatByChatUid(int uid)
    {
        return chatList.get(uid);
    }

    public Friend getFriendByUid(int uid)
    {
        return friendList.get(uid);
    }


    public void setUid(int uid)
    {
        this.uid = uid;
    }
}
