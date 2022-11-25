package client.entities;

import server.entities.Chat;
import server.entities.ChatList;
import server.entities.FriendsList;
import server.entities.User;
import server.entities.UserProfile;

/**
 * Represents a user.
 * @author Kevin Liu
 */
public class CommonUser implements User
{
    private final int uid;
    private final UserProfile userProfile;
    private final server.entities.ChatList chats;
    private final FriendsList friendsList;

    public CommonUser(int uid, String name, int status)
    {
        this.uid = uid;
        userProfile = new UserProfile();
        chats = new ChatList();
        friendsList = new FriendsList();
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
        return chats.getChatByChatUid(uid);
    }

    public CommonUser getFriendByUid(int uid)
    {
        return friendsList.getFriendByUid;
    }


}
