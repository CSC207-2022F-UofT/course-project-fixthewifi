package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.profile_changes.ChangeProfileDsInputModel;
import server.usecases.profile_changes.ChangeProfileGateWayDB;

public class ChPrAccess implements ChangeProfileGateWayDB {

    Database database;

    public ChPrAccess(Database database)
    {
        this.database = database;
    }
    @Override
    public String userAdress(int identifier) {
        return database.readUser(identifier)[7];
    }

    @Override
    public int userPort(int identifier) {
        //todo check whether it return
       // return Integer.parseInt(database.readUser(identifier)[10]);
        return 4444;
    }

    @Override
    public boolean existsByUID(int identifier) {
        return database.checkUserExist(identifier);
    }

    @Override
    public void storeSetPic(ChangeProfileDsInputModel dbModel) {
        database.updateUser(dbModel.getUID(), 5,dbModel.getProfilePic().toString());

    }

    @Override
    public void storeDelPic(ChangeProfileDsInputModel dbModel) {
        database.updateUser(dbModel.getUID(), 5,dbModel.getProfilePic().toString());

    }

    @Override
    public void storeUpdateName(ChangeProfileDsInputModel dbModel) {

        database.updateUser(dbModel.getUID(), 1,dbModel.getName());

    }

    @Override
    public void storeUpdateDescr(ChangeProfileDsInputModel dbModel) {
        database.updateUser(dbModel.getUID(), 2,dbModel.getDescription());

    }
}
