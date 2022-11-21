package frameworks_and_drivers;
import frameworks_and_drivers.Constants;
import frameworks_and_drivers.communication_manager.ComManagerUser;

public class InputSorter implements ComManagerUser
{
    @Override
    public void onMsg(String msg)
    {
        String[] splitMsg = msg.split("\\.", 2);
        int useCaseConstant = Integer.parseInt(splitMsg[0]);
        String content = splitMsg[1];
        switch (useCaseConstant)
        {
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
