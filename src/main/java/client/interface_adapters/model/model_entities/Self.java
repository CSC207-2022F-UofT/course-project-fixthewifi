package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String showFriends()
    {
        StringBuilder out = new StringBuilder("===================Friends===================" + "\n");
        for(Map.Entry<Integer, Friend> entry : friendList.entrySet())
        {
            Friend value = entry.getValue();
            out.append(value.toString());
        }
        return out.toString();
    }

    public List<Integer> getChatUidList()
    {
        return new ArrayList<>(chatList.keySet());
    }


    public List<Integer> getFriendUidList()
    {
        return new ArrayList<>(friendList.keySet());
    }

    public String showChats()
    {
        StringBuilder out = new StringBuilder("===================Chats===================" + "\n");
        for(Map.Entry<Integer, Chat> entry : chatList.entrySet())
        {
            Chat value = entry.getValue();
            out.append(value.toString());
        }
        return out.toString();
    }

    @Override
    public String toString() {
        return "===================My Profile===================" + "\n" +
                "Uid: " + getUid() + "\n" +
                super.profile.toString() + "\n" +
                showFriends() + "\n" +
                showChats();
    }


}
