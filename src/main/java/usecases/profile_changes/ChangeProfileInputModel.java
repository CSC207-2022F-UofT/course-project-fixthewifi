package usecases.profile_changes;

import entities.ProfilePicture;

public class ChangeProfileInputModel {
    private final int profileUID;
    private ProfilePicture pic;
    private String name;
    private String description;

    public ChangeProfileInputModel(int profileUID,  String name, String description,ProfilePicture pic) {
        this.profileUID = profileUID;
        this.pic = pic;
        this.name = name;
        this.description = description;
    }

    public int getProfileUID() {
        return profileUID;
    }

    public ProfilePicture getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}


