package server.interface_adapters.change_profile;

import server.entities.ProfilePicture;
import server.usecases.profile_changes.ChangeProfileInputBoundary;
import server.usecases.profile_changes.ChangeProfileInputModel;
import java.util.Base64;

/**
 * This class is a Controller layer for Changing profile usecase.
 * It is called from Inputsorter class.
 *
 */
public class ChangeProfileController {

    final ChangeProfileInputBoundary inputModelBoundary;

    final char SEPARATOR =30;
    private ChangeProfileInputModel parse(String input){
        String[] separated = input.split(String.valueOf(SEPARATOR));
        int profid = Integer.parseInt(separated[0]);
        String name = separated[1];
        String desc =separated[2];
        ProfilePicture pic = stringToProfPic(separated[3]);
        return new ChangeProfileInputModel(profid,name,desc,pic);
    }

    private ProfilePicture stringToProfPic(String picst){
        byte[] imageBytes;
        imageBytes = Base64.getDecoder().decode(picst);
        return new ProfilePicture(imageBytes);
    }
    public ChangeProfileController(ChangeProfileInputBoundary inputBoundary) {
        this.inputModelBoundary = inputBoundary;
    }

    public void setPic(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.setPic(inputModel);
    }
    public void delPic(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.delPic(inputModel);
    }
    public void updateDescr(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.updateDescr(inputModel);
    }
    public void updateName(String input){
        ChangeProfileInputModel inputModel= parse(input);
        inputModelBoundary.updateName(inputModel);
    }

}
