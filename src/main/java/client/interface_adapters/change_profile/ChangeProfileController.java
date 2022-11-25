package client.interface_adapters.change_profile;

import server.entities.ProfilePicture;
import server.usecases.profile_changes.ChangeProfileInputBoundary;
import server.usecases.profile_changes.ChangeProfileInputModel;
/**
 * This class is a Controller layer for Changing profile usecase.
 * It is called from Inputsorter class.
 *
 */
public class ChangeProfileController {

    final ChangeProfileInputBoundary inputModelBoundary;

    final String SEPARATOR ="$";
    String parse(String input){




        return null;
    }
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
