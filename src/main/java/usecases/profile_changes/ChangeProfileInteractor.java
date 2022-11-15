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

    }

    @Override
    public void delPic(ChangeProfileInputModel inputModel) {

    }

    @Override
    public void updateDescr(ChangeProfileInputModel inputModel) {
       if(database.existsByUID(inputModel.getProfileUID())){
           ChangeProfileDsInputModel dsInputModel= new ChangeProfileDsInputModel(inputModel.getProfileUID(), inputModel.getName(),
                   inputModel.getDescription(), inputModel.getPic());
           database.storeUpdateDescr(dsInputModel);
           ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(inputModel.getProfileUID(), inputModel.getName(),
                   inputModel.getDescription(), inputModel.getPic());
           output.updateDescr(outputModel);
       }

    }

    @Override
    public void updateName(ChangeProfileInputModel inputModel) {

    }
}


