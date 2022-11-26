package client.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Self implements User
{
    private final int uid;
    private final UserProfile userProfile;
    private final HashMap<Integer ,Chat> chatList;
    private final HashMap<Integer, Friend> friendList;

    public Self()
    {
        this.uid = 4396;
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

}
