package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class UserFactory
{
    public static Self newSelf()
    {
        ProfilePicture profilePicture = new ProfilePicture();
        Rating rating = new Rating(0, 0, 0);
        UserProfile userProfile = new UserProfile( "", "", rating, false, profilePicture);

        HashMap<Integer, Chat> chatList = new HashMap<>();
        HashMap<Integer, Friend> friendList = new HashMap<>();
        return new Self(1234567890, userProfile, chatList, friendList);
    }

    public static Friend getFriend(int uid, String name, String description, boolean online)
    {
        ProfilePicture profilePicture = new ProfilePicture();
        Rating rating = new Rating(0, 0, 0);
        UserProfile userProfile = new UserProfile(name, description, rating, online, profilePicture);

        return new Friend(uid, userProfile);

    }

}
