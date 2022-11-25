package server.frameworks_and_drivers;
import server.frameworks_and_drivers.communication_manager.ComManagerUser;

public class InputSorter implements ComManagerUser
{
    public InputSorter()
    {
        //TODO: pass all of the controllers into here
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
            case Constants.CHANGE_PROFILE:
                break;
            case Constants.GROUP_CHAT:
                break;
            case Constants.LOGIN:
                break;

        }
    }

}
