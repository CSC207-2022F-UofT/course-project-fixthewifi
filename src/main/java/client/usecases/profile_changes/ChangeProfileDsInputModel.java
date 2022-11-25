package client.usecases.profile_changes;

import server.entities.ProfilePicture;
/**
 * This class is a data structure for DB interaction.
 *
 */

public class ChangeProfileDsInputModel {
    private final int UID;
    private String name;
    private String description;
    private ProfilePicture profilePic;

    public ChangeProfileDsInputModel(int UID, String name, String description, ProfilePicture profilePic) {
        this.UID = UID;
        this.name = name;
        this.description = description;
        this.profilePic = profilePic;
    }

    public int getUID() {
        return UID;
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

    public ProfilePicture getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(ProfilePicture profilePic) {
        this.profilePic = profilePic;
    }
}


