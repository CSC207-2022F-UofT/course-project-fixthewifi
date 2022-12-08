package server.entities;

import client.interface_adapters.model.model_entities.ProfilePicture;
import client.interface_adapters.model.model_entities.UserProfile;

/**
 * Represents a user.
 * @author Kevin Liu
 */
public class User
{
    private int uid;
    final UserProfile profile;

    public User(int uid, UserProfile profile)
    {
        this.uid = uid;
        this.profile = profile;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return profile.getName();
    }

    public void setName(String name) {
        profile.setName(name);
    }

    public String getDescription() {
        return profile.getDescription();
    }

    public void setDescription(String description) {
        profile.setDescription(description);
    }

    public client.interface_adapters.model.model_entities.ProfilePicture getProfilePicture() {
        return profile.getProfilePicture();
    }

    public void setProfilePicture(ProfilePicture pic) {profile.setProfilePicture(pic); }

    public double getRating()
    {
        return profile.getRating();
    }

    public void setRating(double rating)
    {
        profile.setRating(rating);
    }

    public boolean getStatus()
    {
        return profile.isOnline();
    }

    public void setStatus(boolean online)
    {
        profile.setOnline(online);
    }

    @Override
    public String toString()
    {
        return profile.toString();
    }


}
