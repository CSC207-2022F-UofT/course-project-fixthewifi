package client.interface_adapters.model.model_entities;

import server.entities.ProfilePicture;

public interface Profile {

    public int getUID();

    public  String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String description);

    public ProfilePicture getProfilePicture();
    public void setProfilePicture(ProfilePicture pic);
}