package usecases.profile_changes;

import entities.ProfilePicture;

public interface ChangeProfileInputBoundary {
    void setPic(ChangeProfileInputModel inputModel);
    void delPic(ChangeProfileInputModel inputModel);
    void updateDescr(ChangeProfileInputModel inputModel);
    void updateName(ChangeProfileInputModel inputModel);


}


