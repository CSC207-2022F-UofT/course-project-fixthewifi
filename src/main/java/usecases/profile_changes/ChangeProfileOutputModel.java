package usecases.profile_changes;

import entities.ProfilePicture;

public class ChangeProfileOutputModel {
    private final int profileUID;
    private boolean success;

    public ChangeProfileOutputModel(int profileUID, boolean success) {
        this.profileUID = profileUID;
        this.success = success;
    }

    public int getProfileUID() {
        return profileUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}


