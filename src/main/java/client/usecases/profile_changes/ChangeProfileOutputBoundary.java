package client.usecases.profile_changes;

import server.usecases.profile_changes.ChangeProfileOutputModel;

/**
 * This class is an interface for ChangeProfileOutputAdapter class.
 * It is used in ChangeProfileInteractor class to make connection
 * to the ChangeProfileOutputAdapter.
 *
 */
public interface ChangeProfileOutputBoundary {

    void setPic(server.usecases.profile_changes.ChangeProfileOutputModel outputModel);
    void delPic(server.usecases.profile_changes.ChangeProfileOutputModel outputModel);
    void updateDescr(server.usecases.profile_changes.ChangeProfileOutputModel outputModel);
    void updateName(ChangeProfileOutputModel outputModel);

    /**
     * This method is for failing changes in Changing profile.
     */
    void errorChangingProfile();
}


