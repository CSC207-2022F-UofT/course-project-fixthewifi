package client.interface_adapters.profile;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.profile_changes.ChangeProfileOutputBoundary;
import server.usecases.profile_changes.ChangeProfileOutputModel;

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
        String adress = outputModel.getUseraddress(); //from db!!
        int port = outputModel.getUserport(); //from db!!
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
