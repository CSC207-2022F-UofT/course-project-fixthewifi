package entities;

/**
 * Represents the profile of a user.
 * @author Kevin Liu
 */
public class UserProfile
{
    private String name;
    private Rating rating;
    private ProfilePicture profilePic;

    public ProfilePicture getProfilePic()
    {
        return profilePic;
    }
}
