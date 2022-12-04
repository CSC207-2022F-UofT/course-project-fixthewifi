package server.interface_adapters.change_profile;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.profile_changes.ChangeProfileOutputBoundary;
import server.usecases.profile_changes.ChangeProfileOutputModel;
import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.profile_changes.ChangeProfileOutputBoundary;
import server.usecases.profile_changes.ChangeProfileOutputModel;

/**
 * This class is a OutputAdapter layer for Changing profile usecase.
 * It is called from Interactor class and pass the information to the comManager.
 *
 */
public class ChangeProfileOutputAdapter implements ChangeProfileOutputBoundary {

    private final IfComManager comManager;
    char SEPARATOR = 30;
    String HASH = "#";

    public ChangeProfileOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    /**
     * Codeconstants are for coding the command
     */

    @Override
    public void setPic(ChangeProfileOutputModel outputModel) {
        String content = Constants.SET_PIC+HASH+ outputModel.getProfileUID()+SEPARATOR+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void delPic(ChangeProfileOutputModel outputModel) {
        String content = Constants.DEL_PIC+HASH+ outputModel.getProfileUID()+SEPARATOR+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }

    @Override
    public void updateDescr(ChangeProfileOutputModel outputModel) {
        String content = Constants.UPDATE_DESC+ HASH+outputModel.getProfileUID()+SEPARATOR+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);


    }

    @Override
    public void updateName(ChangeProfileOutputModel outputModel) {

        String content = Constants.UPDATE_NAME+ HASH+outputModel.getProfileUID()+SEPARATOR+outputModel.getChangedDataString();
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

     }

    @Override
    public void errorChangingProfile(ChangeProfileOutputModel outputModel, int code) {
        String content = code+HASH+"changing fails!";
        comManager.send(outputModel.getUseraddress(),outputModel.getUserport(),content);

    }
}
