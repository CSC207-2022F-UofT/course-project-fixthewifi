package client.interface_adapters.model.model_entities;

public abstract class Profile
{
    private String name;
    private String description;
    private ProfilePicture pic;

    public Profile(String name, String description)
    {
        //to create a GroupProfile without a ProfilePicture
        this.name = name;
        this.description = description;
        this.pic = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfilePicture getProfilePicture() {
        return this.pic;
    }

    public void setProfilePicture(ProfilePicture pic) {this.pic = pic; }

    @Override
    public abstract String toString();
}