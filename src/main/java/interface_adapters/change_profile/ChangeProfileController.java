package interface_adapters.change_profile;

import entities.ProfilePicture;
import usecases.profile_changes.ChangeProfileInputBoundary;
import usecases.profile_changes.ChangeProfileInputModel;

public class ChangeProfileController {

    final ChangeProfileInputBoundary inputModelBoundary;

    public ChangeProfileController(ChangeProfileInputBoundary accountGateway) {
        this.inputModelBoundary = accountGateway;
    }

    void setPic(int profId, String name, String description, ProfilePicture pic){
        ChangeProfileInputModel inputModel= new ChangeProfileInputModel(profId,name,description,pic);
        inputModelBoundary.setPic(inputModel);
    }
    void delPic(int profId, String name, String description, ProfilePicture pic){
        ChangeProfileInputModel inputModel= new ChangeProfileInputModel(profId,name,description,pic);
        inputModelBoundary.delPic(inputModel);
    }
    void updateDescr(int profId, String name, String description, ProfilePicture pic){
        ChangeProfileInputModel inputModel= new ChangeProfileInputModel(profId,name,description,pic);
        inputModelBoundary.updateDescr(inputModel);
    }
    void updateName(int profId, String name, String description, ProfilePicture pic){
        ChangeProfileInputModel inputModel= new ChangeProfileInputModel(profId,name,description,pic);
        inputModelBoundary.updateName(inputModel);
    }

}
