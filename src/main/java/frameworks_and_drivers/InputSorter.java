package frameworks_and_drivers;
import frameworks_and_drivers.communication_manager.ComManagerUser;
import interface_adapters.change_profile.ChangeProfileController;

public class InputSorter implements ComManagerUser
{
    ChangeProfileController changeProfileController;
    public InputSorter( ChangeProfileController changeProfileController)
    {
        //TODO: pass all of the controllers into here
        this.changeProfileController= changeProfileController;
    }

    /**
     * When a message is received, onMsg will be triggered by comManager.
     @param msg The received message.
     */
    @Override
    public void onMsg(String msg)
    {
        String[] splitMsg = msg.split("\\.", 2);
        int useCaseConstant = Integer.parseInt(splitMsg[0]);
        String content = splitMsg[1];
        switch (useCaseConstant)
        {
            //TODO: each case will trigger the corresponding method in the corresponding controller for the corresponding usecase.
            case Constants.SEND_CHAT:
                break;
            case Constants.UPDATE_NAME:
                changeProfileController.updateName(content);
            case Constants.UPDATE_DESC:
                changeProfileController.updateDescr(content);
            case Constants.SET_PIC:
                changeProfileController.setPic(content);
            case Constants.DEL_PIC:
                changeProfileController.delPic(content);
            case Constants.GROUP_CHAT:
                break;
            case Constants.LOGIN:
                break;

        }
    }

}
