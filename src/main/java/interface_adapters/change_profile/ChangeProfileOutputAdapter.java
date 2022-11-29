package interface_adapters.change_profile;

import frameworks_and_drivers.Constants;
import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.profile_changes.ChangeProfileOutputBoundary;
import usecases.profile_changes.ChangeProfileOutputModel;

/**
 * This class is a OutputAdapter layer for Changing profile usecase.
 * It is called from Interactor class and pass the information to the comManager.
 *
 */
public class ChangeProfileOutputAdapter implements ChangeProfileOutputBoundary {

    private final IfComManager comManager;
    String SEPARATOR = "#";

    public ChangeProfileOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * Codeconstants are for coding the command
     */

    @Override
    public void setPic(ChangeProfileOutputModel outputModel) {
        String content = Constants.SET_PIC+ outputModel.getProfileUID()+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void delPic(ChangeProfileOutputModel outputModel) {
        String content = Constants.DEL_PIC+ outputModel.getProfileUID()+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void updateDescr(ChangeProfileOutputModel outputModel) {
        String content = Constants.UPDATE_DESC+ SEPARATOR+outputModel.getProfileUID()+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);


    }

    @Override
    public void updateName(ChangeProfileOutputModel outputModel) {

        String content = Constants.UPDATE_NAME+ SEPARATOR+outputModel.getProfileUID()+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

     }

    @Override
    public void errorChangingProfile(ChangeProfileOutputModel outputModel, int code) {
        String content = "changing fails!";
        comManager.send(code+SEPARATOR+outputModel.getUseraddress(),outputModel.getUserport(),content);

    }
}
