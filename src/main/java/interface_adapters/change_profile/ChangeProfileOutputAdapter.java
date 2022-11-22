package interface_adapters.change_profile;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.profile_changes.ChangeProfileOutputBoundary;
import usecases.profile_changes.ChangeProfileOutputModel;

import java.util.List;
/**
 * This class is a OutputAdapter layer for Changing profile usecase.
 * It is called from Interactor class and pass the information to the comManager.
 *
 */
public class ChangeProfileOutputAdapter implements ChangeProfileOutputBoundary {

    private final IfComManager comManager;
    public ChangeProfileOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * Codeconstants are for coding the command
     */
    final int CODEDEL = 0;
    final int CODESET = 0;
    final int CODENAME = 0;
    final int CODEDESC = 0;
    @Override
    public void setPic(ChangeProfileOutputModel outputModel) {
        String content = CODESET+ outputModel.getProfileUID()+outputModel.getChangeStatusMessage();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void delPic(ChangeProfileOutputModel outputModel) {
        String content = CODEDEL+ outputModel.getProfileUID()+outputModel.getChangeStatusMessage();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void updateDescr(ChangeProfileOutputModel outputModel) {
        String content = CODEDESC+ outputModel.getProfileUID()+outputModel.getChangeStatusMessage();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);


    }

    @Override
    public void updateName(ChangeProfileOutputModel outputModel) {
        String content = CODENAME+ outputModel.getProfileUID()+outputModel.getChangeStatusMessage();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

     }

    @Override
    public void errorChangingProfile(ChangeProfileOutputModel outputModel) {
        String content = "Updating fails!";
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }
}
