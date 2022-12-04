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

    public void addFriend(int uid, String name, String description, double rating, boolean online)
    {
        Friend friend = UserFactory.getFriend(uid, name, description, online);
        friend.profile.setRating(rating);
        friendList.put(uid,friend);
    }

    public void addChat(int uid, String name, String description, String[] messages) {
        Chat chat = ChatFactory.getChat(uid, name, description);
    }
}
