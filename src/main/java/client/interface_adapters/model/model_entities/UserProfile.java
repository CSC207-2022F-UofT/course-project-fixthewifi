package client.interface_adapters.model.model_entities;

/**
 * Represents the profile of a user.
 */
public class UserProfile
{
    private String name;
    private String description;
    private Rating rating;
    private boolean online;
    private ProfilePicture profilePic;

    public UserProfile(String name, String description, Rating rating, boolean online, ProfilePicture profilePic)
    {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.online = online;
        this.profilePic = profilePic;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating.getAvgRating();
    }

    public void setRating(double submittedRating) {
        rating.calculateAvgRating(submittedRating);
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setProfilePic(ProfilePicture profilePic) {
        this.profilePic = profilePic;
    }

    public ProfilePicture getProfilePic()
    {
        return profilePic;
    }

    public String getStatus()
    {
        if (online)
        {
            return "Online";
        }
        return "Offline";
    }
}
