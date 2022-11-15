package interface_adapters.change_profile;

import frameworks_and_drivers.comManager.IfComManager;
import usecases.profile_changes.ChangeProfileOutputBoundary;
import usecases.profile_changes.ChangeProfileOutputModel;

import java.util.List;

public class ChangeProfileOutputAdapter implements ChangeProfileOutputBoundary {

    private IfComManager comManager;
    public ChangeProfileOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    @Override
    public void setPic(ChangeProfileOutputModel inputModel) {

    }

    @Override
    public void delPic(ChangeProfileOutputModel inputModel) {

    }

    @Override
    public void updateDescr(ChangeProfileOutputModel inputModel) {
        String content = inputModel.getProfileUID()+inputModel.getName() + inputModel.getDescription() + inputModel.getPic();
//        for(List<String> AddressPair : inputModel.chatMembersAddress)
//        {
//            comManager.send(AddressPair.get(0), Integer.parseInt(AddressPair.get(1)), content);
//        }
    }

    @Override
    public void updateName(ChangeProfileOutputModel inputModel) {

    }
}
