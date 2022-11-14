package usecases.profile_changes;

import entities.ProfilePicture;

public interface ChangeProfileInputBoundary {
    ChangeProfileOutputModel setPic(ChangeProfileInputModel inputModel);
    ChangeProfileOutputModel delPic(ChangeProfileInputModel inputModel);
    ChangeProfileOutputModel updateDescr(ChangeProfileInputModel inputModel);
    ChangeProfileOutputModel updateName(ChangeProfileInputModel inputModel);
}


