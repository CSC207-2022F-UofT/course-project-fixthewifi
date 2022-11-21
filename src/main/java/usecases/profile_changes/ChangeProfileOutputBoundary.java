package usecases.profile_changes;

/**
 * This class is an interface for ChangeProfileOutputAdapter class.
 * It is used in ChangeProfileInteractor class to make connection
 * to the ChangeProfileOutputAdapter.
 *
 */
public interface ChangeProfileOutputBoundary {

    void setPic(ChangeProfileOutputModel outputModel);
    void delPic(ChangeProfileOutputModel outputModel);
    void updateDescr(ChangeProfileOutputModel outputModel);
    void updateName(ChangeProfileOutputModel outputModel);

    /**
     * This method is for failing changes in Changing profile.
     */
    void errorChangingProfile();
}


