package client.interface_adapters.model.model_entities;

public abstract class User
{
    private int uid;
    private final UserProfile profile;

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

    public ProfilePicture getProfilePicture() {
        return profile.getProfilePicture();
    }

    public void setProfilePicture(ProfilePicture pic) {profile.setProfilePicture(pic); }
}
