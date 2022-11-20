package usecases.profile_changes;

import interface_adapters.change_profile.ChangeProfileOutputAdapter;

public class ChangeProfileInteractor implements ChangeProfileInputBoundary{
    final ChangeProfileGateWayDB database;

    final ChangeProfileOutputBoundary output;

    public ChangeProfileInteractor(ChangeProfileGateWayDB profileGateWayDB, ChangeProfileOutputAdapter profileOutputAdapter) {
        this.database = profileGateWayDB;
        this.output = profileOutputAdapter;
    }

    @Override
    public void setPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeSetPic(dsInputModel);

            String succssesmessage = "Picture set successfully!";
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(inputModel.getProfileUID(), succssesmessage);
            output.setPic(outputModel);

        }
        else{
            output.errorChangingProfile();//todo what to do if error
        }
    }

    @Override
    public void delPic(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeDelPic(dsInputModel);

            String succssesmessage = "Picture deleted successfully!";
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(inputModel.getProfileUID(), succssesmessage);
            output.delPic(outputModel);

        }
        else{
            output.errorChangingProfile();//todo what to do if error
        }
    }

    @Override
    public void updateDescr(ChangeProfileInputModel inputModel) {
       if(database.existsByUID(inputModel.getProfileUID())){
           ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                   inputModel.getDescription(), inputModel.getPic());
           database.storeUpdateDescr(dsInputModel);

           String succssesmessage = "Description Updated successfully!";
           ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(inputModel.getProfileUID(), succssesmessage);
           output.updateDescr(outputModel);

       }
       else{
           output.errorChangingProfile();//todo what to do if error
       }

    }

    @Override
    public void updateName(ChangeProfileInputModel inputModel) {
        if(database.existsByUID(inputModel.getProfileUID())){
            ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                    inputModel.getDescription(), inputModel.getPic());
            database.storeUpdateName(dsInputModel);

            String succssesmessage = "Name Updated successfully!";
            ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(inputModel.getProfileUID(), succssesmessage);
            output.updateName(outputModel);

        }
        else{
            output.errorChangingProfile();//todo what to do if error
        }
    }
}


