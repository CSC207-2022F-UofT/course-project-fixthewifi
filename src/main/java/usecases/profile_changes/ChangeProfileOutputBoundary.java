package usecases.profile_changes;

public interface ChangeProfileOutputBoundary {

    void setPic(ChangeProfileOutputModel outputModel);
    void delPic(ChangeProfileOutputModel outputModel);
    void updateDescr(ChangeProfileOutputModel outputModel);
    void updateName(ChangeProfileOutputModel outputModel);

    void errorChangingProfile();
}


