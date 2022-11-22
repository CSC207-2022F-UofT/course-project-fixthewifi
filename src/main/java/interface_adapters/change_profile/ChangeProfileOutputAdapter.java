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

    private IfComManager comManager;
    public ChangeProfileOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    @Override
    public void setPic(ChangeProfileOutputModel outputModel) {
    //todo write a implementation for a presenter
    }

    @Override
    public void delPic(ChangeProfileOutputModel outputModel) {
//todo write a implementation for a presenter
    }

    @Override
    public void updateDescr(ChangeProfileOutputModel outputModel) {
        String content = outputModel.getProfileUID()+outputModel.getChangeStatusMessage();

       // adress and port from db
        String adress = ""; //from db!!
        int port = 0; //from db!!
        comManager.send(adress,port,content);

        //send to commanager a meesage to myself
        //comManager.
        //todo write a implementation for a presenter

    }

    @Override
    public void updateName(ChangeProfileOutputModel outputModel) {

        //todo write a implementation for a presenter
    }

    @Override
    public void errorChangingProfile() {

    }
}
