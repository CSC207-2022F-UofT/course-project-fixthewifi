package client.interface_adapters.model.model_entities;

/**
 * Represents the profile of a user.
 */
public class UserProfile extends Profile
{
    private Rating rating;
    private boolean online;

    public UserProfile(String name, String description, Rating rating, boolean online)
    {
        super(name, description);
        this.rating = rating;
        this.online = online;
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

    public String getOnline()
    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", online=" + online +
                ", profilePic=" + profilePic +
                '}';
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
            return "T";
        }
        return "F";
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Online?: " + getOnline() + "\n";
    }
}
