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
    public double getRating() {
        return rating.getAvgRating();
    }

    public void setRating(double rating) {
        this.rating.setRating(rating);
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
