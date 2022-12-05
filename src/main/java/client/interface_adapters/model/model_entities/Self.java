package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class Self extends User
{
    private final HashMap<Integer ,Chat> chatList;
    private final HashMap<Integer, Friend> friendList;

    public Self(int uid, UserProfile userProfile, HashMap<Integer, Chat> chatList, HashMap<Integer, Friend> friendList)
    {
        super(uid, userProfile);
        this.chatList = chatList;
        this.friendList = friendList;
    }

    public Friend getFriend(int uid)
    {
        return friendList.get(uid);
    }

    public void addFriend(Friend friend)
    {
        friendList.put(friend.getUid(), friend);
    }

    public void deleteFriend(int friendUid)
    {
        friendList.remove(friendUid);
    }

    public Chat getChat(int uid)
    {
        return chatList.get(uid);
    }
    public void addChat(Chat chat)
    {
        chatList.put(chat.getUid(), chat);
    }

    public void deleteChat(int chatUid)
    {
        chatList.remove(chatUid);
    }
}
