package interface_adapters.change_profile;

import entities.ProfilePicture;
import usecases.profile_changes.ChangeProfileInputBoundary;
import usecases.profile_changes.ChangeProfileInputModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

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
