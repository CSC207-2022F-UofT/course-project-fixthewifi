package usecases.profile_changes;

import interface_adapters.change_profile.ChangeProfileOutputAdapter;

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
    public ChangeProfileInteractor(ChangeProfileGateWayDB profileGateWayDB, ChangeProfileOutputAdapter profileOutputAdapter) {
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
     */
    @Override
    public void setPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            String succssesmessage = "Picture set successfully!";
            database.storeSetPic(createDsModel(inputModel));
            output.setPic(createOutputModel(inputModel,succssesmessage));
        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage));

        }
    }
    /**
     * void for deleting pic
     */
    @Override
    public void delPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){

            database.storeDelPic(createDsModel(inputModel));
            String succssesmessage = "Picture deleted successfully!";
            output.delPic(createOutputModel(inputModel,succssesmessage));

        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage));
        }
    }
    /**
     * void for updating description
     */
    @Override
    public void updateDescr(ChangeProfileInputModel inputModel) {
       if(database.existsByUID(inputModel.getProfileUID())){
           database.storeUpdateDescr(createDsModel(inputModel));
           String succssesmessage = "Description updated successfully!";
           output.updateDescr(createOutputModel(inputModel,succssesmessage));

       }
       else {
           output.errorChangingProfile(createOutputModel(inputModel, failmessage));
       }

    }
    /**
     * void for updating name
     */
    @Override
    public void updateName(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){

            database.storeUpdateName(createDsModel(inputModel));
            String succssesmessage = "Name updated successfully!";
            output.updateName(createOutputModel(inputModel,succssesmessage));

        }
        else{
            output.errorChangingProfile(createOutputModel(inputModel,failmessage));

        }
    }
}


