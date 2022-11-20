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

    public ChangeProfileInteractor(ChangeProfileGateWayDB profileGateWayDB, ChangeProfileOutputAdapter profileOutputAdapter) {
        this.database = profileGateWayDB;
        this.output = profileOutputAdapter;
    }
    /**
     * void for setting new pic
     */
    @Override
    public void setPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeSetPic(dsInputModel);


            String succssesmessage = "Picture set successfully!";
            String address="";//from db
            int port = 0;//from db
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(address,port,inputModel.getProfileUID(), succssesmessage);
            output.setPic(outputModel);

        }
        else{
            output.errorChangingProfile();//todo what to do if error
        }
    }
    /**
     * void for deleting pic
     */
    @Override
    public void delPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeDelPic(dsInputModel);

            String succssesmessage = "Picture set successfully!";
            String address="";//from db
            int port = 0;//from db
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(address,port,inputModel.getProfileUID(), succssesmessage);
            output.delPic(outputModel);

        }
        else{
            output.errorChangingProfile();//todo what to do if error
        }
    }
    /**
     * void for updating description
     */
    @Override
    public void updateDescr(ChangeProfileInputModel inputModel) {
       if(database.existsByUID(inputModel.getProfileUID())){
           ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                   inputModel.getDescription(), inputModel.getPic());
           database.storeUpdateDescr(dsInputModel);

           String succssesmessage = "Picture set successfully!";
           String address="";//from db
           int port = 0;//from db
           ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(address,port,inputModel.getProfileUID(), succssesmessage);
           output.updateDescr(outputModel);

       }
       else{
           output.errorChangingProfile();//todo what to do if error
       }

    }
    /**
     * void for updating name
     */
    @Override
    public void updateName(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeUpdateName(dsInputModel);

            String succssesmessage = "Picture set successfully!";
            String address="";//from db
            int port = 0;//from db
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(address,port,inputModel.getProfileUID(), succssesmessage);
            output.updateName(outputModel);

        }
        else{
            output.errorChangingProfile();
            //todo what to do if error
        }
    }
}


