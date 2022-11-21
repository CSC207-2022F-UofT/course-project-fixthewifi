package frameworks_and_drivers;

import entities.UserProfile;
import usecases.profile_changes.ChangeProfileDsInputModel;
import usecases.profile_changes.ChangeProfileGateWayDB;
import usecases.profile_changes.ChangeProfileInputModel;

//here i will use ChangeProfileDsInputModel and have access to txt files

public class ChangeProfileDB implements ChangeProfileGateWayDB {
    @Override
    public String userAdress(int identifier) {
        return null;
    }

    @Override
    public int userPort(int identifier) {
        return 0;
    }

    @Override
    public boolean existsByUID(int identifier) {
        return false;
    }

    @Override
    public ChangeProfileDsInputModel getByID(int id) {
        return null;
    }

    @Override
    public void storeSetPic(ChangeProfileDsInputModel dbModel) {

    }

    @Override
    public void storeDelPic(ChangeProfileDsInputModel dbModel) {

    }

    @Override
    public void storeUpdateName(ChangeProfileDsInputModel dbModel) {

    }

    @Override
    public void storeUpdateDescr(ChangeProfileDsInputModel dbModel) {
//todo implementation of storing in db
    }
}
