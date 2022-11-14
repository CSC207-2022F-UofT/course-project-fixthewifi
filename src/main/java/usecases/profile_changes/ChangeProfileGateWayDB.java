package usecases.profile_changes;

public interface ChangeProfileGateWayDB {
    boolean existsByUID(int identifier);

//    void save(ChangeProfileDsInputModel dbModel);

    void storeSetPic(ChangeProfileDsInputModel dbModel);
    void storeDelPic(ChangeProfileDsInputModel dbModel);
    void storeUpdateName(ChangeProfileDsInputModel dbModel);
    void storeUpdateDescr(ChangeProfileDsInputModel dbModel);
}


