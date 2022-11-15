package usecases.profile_changes;

import entities.UserProfile;

public interface ChangeProfileGateWayDB {
    boolean existsByUID(int identifier);

    ChangeProfileDsInputModel getByID(int id);
//    void save(ChangeProfileDsInputModel dbModel);

    void storeSetPic(ChangeProfileDsInputModel dbModel);
    void storeDelPic(ChangeProfileDsInputModel dbModel);
    void storeUpdateName(ChangeProfileDsInputModel dbModel);
    void storeUpdateDescr(ChangeProfileDsInputModel dbModel);
}


