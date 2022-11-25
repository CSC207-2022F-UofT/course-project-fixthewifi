package client.usecases.profile_changes;

import server.usecases.profile_changes.ChangeProfileInputModel;

/**
 * This class is an interface for ChangeProfileInteractor class.
 * It is used in ChangeProfileController class to make connection
 * to the Interactor.
 *
 */
public interface ChangeProfileInputBoundary {
    void setPic(server.usecases.profile_changes.ChangeProfileInputModel inputModel);
    void delPic(server.usecases.profile_changes.ChangeProfileInputModel inputModel);
    void updateDescr(server.usecases.profile_changes.ChangeProfileInputModel inputModel);
    void updateName(ChangeProfileInputModel inputModel);


}


