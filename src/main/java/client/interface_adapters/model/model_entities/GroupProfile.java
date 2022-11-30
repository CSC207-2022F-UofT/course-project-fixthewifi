package client.interface_adapters.model.model_entities;

import server.entities.Profile;
import server.entities.ProfilePicture;

/**
 * This class represents the profile of a given GroupChat.
 * @author Brenden McFarlane
 */
public class GroupProfile implements Profile {
    private final int UID;
    private String name;
    private String description;
    private ProfilePicture pic;

    public GroupProfile(int UID, String name, String description){
        //to create a GroupProfile without a ProfilePicture
        this.UID = UID;
        this.name = name;
        this.description = description;
        this.pic = null;
    }
    public GroupProfile(int UID, String name, String description, ProfilePicture pic){
        this.UID = UID;
        this.name = name;
        this.description = description;
        this.pic = pic;
    }

    @Override
    public int getUID() {
        return UID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ProfilePicture getProfilePicture() {
        return this.pic;
    }

    @Override
    public void setProfilePicture(ProfilePicture pic) {this.pic = pic; }
}
