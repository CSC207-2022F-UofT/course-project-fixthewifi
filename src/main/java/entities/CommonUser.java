package entities;

/**
 * Represents a user.
 * @author Kevin Liu
 */
public class CommonUser implements User
{
    private int uid;
    private UserProfile userProfile;
    private Status status;
    private ChatList chats;
    private FriendsList friendsList;

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

    public int getStatus()
    {
        return status.getStatus();
    }

    public String getStringStatus()
    {
        return status.toString();
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
