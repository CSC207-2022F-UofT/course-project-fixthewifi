package interface_adapters.change_profile;

import entities.ProfilePicture;
import usecases.profile_changes.ChangeProfileInputBoundary;
import usecases.profile_changes.ChangeProfileInputModel;
/**
 * This class is a Controller layer for Changing profile usecase.
 * It is called from Inputsorter class.
 *
 */
public class ChangeProfileController {

    final ChangeProfileInputBoundary inputModelBoundary;

    final String SEPARATOR ="$";
    private ChangeProfileInputModel parse(String input){
        String[] separated = input.split("\\$");
        int profid = Integer.parseInt(separated[0]);
        String name = separated[1];
        String desc =separated[2];
        ProfilePicture pic = stringToProfPic(separated[3]);
        return new ChangeProfileInputModel(profid,name,desc,pic);
    }

    private ProfilePicture stringToProfPic(String picst){
        //todo realization of converting string to profile picture object
        return null;
    }
    public ChangeProfileController(ChangeProfileInputBoundary inputBoundary) {
        this.inputModelBoundary = inputBoundary;
    }

    void setPic(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.setPic(inputModel);
    }
    void delPic(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.delPic(inputModel);
    }
    void updateDescr(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.updateDescr(inputModel);
    }
    void updateName(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.updateName(inputModel);
    }

}
