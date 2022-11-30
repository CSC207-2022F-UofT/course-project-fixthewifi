package server.usecases.profile_changes;
import server.interface_adapters.change_profile.ChangeProfileOutputAdapter;
import server.frameworks_and_drivers.Constants;
import server.interface_adapters.change_profile.ChangeProfileOutputAdapter;

import java.util.Arrays;

/**
 * This class implements ChangeProfileInputBoundary interface
 * and do the implementation for Changing profile features
 * such as updating name, updating description, setting new photo and deleting photo.
 * Through ChangeProfileGateWayDB interface it has access to the ChangeProfileDB.
 * Through ChangeProfileOutputBoundary interface it has access to the ChangeProfileOutputAdapter.
 *
 */
public class ChangeProfileInteractor implements ChangeProfileInputBoundary{
    final ChangeProfileGateWayDB database;
    final ChangeProfileOutputBoundary output;
    final String  failmessage = "fail";
    public ChangeProfileInteractor(ChangeProfileGateWayDB profileGateWayDB, ChangeProfileOutputBoundary profileOutputAdapter) {
        this.database = profileGateWayDB;
        this.output = profileOutputAdapter;
    }

    ChangeProfileDsInputModel createDsModel(ChangeProfileInputModel inputModel){
        return new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                inputModel.getDescription(), inputModel.getPic());
    }

    ChangeProfileOutputModel createOutputModel(ChangeProfileInputModel inputModel, String succssesmessage){
        String address = database.userAdress(inputModel.getProfileUID());
        int port =database.userPort(inputModel.getProfileUID());

        return new ChangeProfileOutputModel(address,port,inputModel.getProfileUID(), succssesmessage);
    }
    /**
     * void for setting new pic
     * send a pic bytes in string to a user
     */
    @Override
    public void setPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            String succssesmessage = Arrays.toString(inputModel.getPic().getImageBytes());
            database.storeSetPic(createDsModel(inputModel));
            output.setPic(createOutputModel(inputModel,succssesmessage));
        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage), Constants.SET_PIC);

        }
    }
    /**
     * void for deleting pic
     * send a Picture deleted successfully! to a user
     */
    @Override
    public void delPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){

            database.storeDelPic(createDsModel(inputModel));
            String succssesmessage = "Picture deleted successfully!";
            output.delPic(createOutputModel(inputModel,succssesmessage));

        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage), Constants.DEL_PIC);
        }
    }
    /**
     * void for updating description
     * send a string of new descriprion to a user
     */
    @Override
    public void updateDescr(ChangeProfileInputModel inputModel) {
       if(database.existsByUID(inputModel.getProfileUID())){
           database.storeUpdateDescr(createDsModel(inputModel));
           String succssesmessage = inputModel.getDescription();
           output.updateDescr(createOutputModel(inputModel,succssesmessage));

       }
       else {
           output.errorChangingProfile(createOutputModel(inputModel, failmessage), Constants.UPDATE_DESC);
       }

    }
    /**
     * void for updating name
     *  send a string of new name to a user
     *
     */
    @Override
    public void updateName(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){

            database.storeUpdateName(createDsModel(inputModel));
            String succssesmessage = inputModel.getName();
            output.updateName(createOutputModel(inputModel,succssesmessage));

        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage),Constants.UPDATE_NAME);

        }
    }
}


