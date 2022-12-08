package server.entities;

import client.interface_adapters.model.model_entities.Friend;
import client.interface_adapters.model.model_entities.Rating;
import client.interface_adapters.model.model_entities.UserProfile;

public class UserFactory
{
    public static User newUser(int uid, String name, String description, double avgRating, boolean online)
    {
        Rating rating = new Rating(avgRating, 0, 0);
        UserProfile userProfile = new UserProfile(name, description, rating, online);

        return new User(uid, userProfile);
    }

}
