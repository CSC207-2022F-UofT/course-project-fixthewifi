package server.usecases.profile_changes;

/**
 * This class is an interface for ChangeProfileInteractor class.
 * It is used in ChangeProfileController class to make connection
 * to the Interactor.
 *
 */
public interface ChangeProfileInputBoundary {
    void setPic(ChangeProfileInputModel inputModel);
    void delPic(ChangeProfileInputModel inputModel);
    void updateDescr(ChangeProfileInputModel inputModel);
    void updateName(ChangeProfileInputModel inputModel);


}


