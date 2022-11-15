package usecases.profile_changes;

public interface ChangeProfileOutputBoundary {

    void setPic(ChangeProfileOutputModel inputModel);
    void delPic(ChangeProfileOutputModel inputModel);
    void updateDescr(ChangeProfileOutputModel inputModel);
    void updateName(ChangeProfileOutputModel inputModel);

}


