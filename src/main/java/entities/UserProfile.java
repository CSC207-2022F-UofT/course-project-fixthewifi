package entities;

/**
 * Represents the profile of a user.
 */
public class UserProfile
{
    private String name;
    private Rating rating;
    private boolean online;
    private ProfilePicture profilePic;

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
