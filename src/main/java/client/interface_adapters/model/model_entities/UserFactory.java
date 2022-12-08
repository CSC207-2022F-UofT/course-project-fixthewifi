package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class UserFactory
{
    public static Self newSelf()
    {
        Rating rating = new Rating(0, 0, 0);
        UserProfile userProfile = new UserProfile( "", "", rating, false);

        HashMap<Integer, Chat> chatList = new HashMap<>();
        HashMap<Integer, Friend> friendList = new HashMap<>();
        return new Self(-1, userProfile, chatList, friendList);
    }

    public static Friend newFriend(int uid, String name, String description, double avgRating, boolean online)
    {
        Rating rating = new Rating(avgRating, 0, 0);
        UserProfile userProfile = new UserProfile(name, description, rating, online);

        return new Friend(uid, userProfile);

    }

    public static User newUser(int uid, String name, String description, double avgRating, boolean online)
    {
        Rating rating = new Rating(avgRating, 0, 0);
        UserProfile userProfile = new UserProfile(name, description, rating, online);

        return new Friend(uid, userProfile);
    }

}
