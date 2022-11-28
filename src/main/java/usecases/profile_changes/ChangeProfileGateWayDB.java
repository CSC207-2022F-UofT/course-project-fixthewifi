package usecases.profile_changes;

/**
 * This class is an interface for ChangeProfileDB class.
 * It is used in ChangeProfileInteractor class to make connection
 * to the ChangeProfileDB.
 *
 */
public interface ChangeProfileGateWayDB {
    String userAdress(int identifier);
    int userPort(int identifier);
    boolean existsByUID(int identifier);

    void storeSetPic(ChangeProfileDsInputModel dbModel);
    void storeDelPic(ChangeProfileDsInputModel dbModel);
    void storeUpdateName(ChangeProfileDsInputModel dbModel);
    void storeUpdateDescr(ChangeProfileDsInputModel dbModel);
}


