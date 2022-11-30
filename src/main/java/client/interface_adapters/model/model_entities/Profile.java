package client.interface_adapters.model.model_entities;

public interface Profile {


    public  String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String description);

    public ProfilePicture getProfilePicture();
    public void setProfilePicture(ProfilePicture pic);
}