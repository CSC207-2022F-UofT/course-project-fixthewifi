package client.frameworks_and_drivers;
import client.frameworks_and_drivers.communication_manager.ComManagerUser;
import client.interface_adapters.presenters.FriendPresenter;
import client.interface_adapters.presenters.LoginPresenter;

import client.interface_adapters.presenters.change_profile.ChPrPresenter;

import client.interface_adapters.presenters.RatingPresenter;


public class InputSorter implements ComManagerUser
{
    private final FriendPresenter friendPresenter;
    private final LoginPresenter loginPresenter;

    private final ChPrPresenter chPrPresenter;
    private final RatingPresenter ratingPresenter;
    public InputSorter(FriendPresenter friendPresenter, LoginPresenter loginPresenter, ChPrPresenter chPrPresenter, RatingPresenter ratingPresenter)

    {
        this.friendPresenter = friendPresenter;
        this.loginPresenter = loginPresenter;

        this.chPrPresenter= chPrPresenter;

        this.ratingPresenter = ratingPresenter;

    }
    
    /**
     * When a message is received, onMsg will be triggered by comManager.
     @param msg The received message.
     */
    @Override
    public void onMsg(String msg)
    {
        String[] splitMsg = msg.split("#", 2);
        int useCaseConstant = Integer.parseInt(splitMsg[0]);
        String content = splitMsg[1];
        switch (useCaseConstant)
        {
            //TODO: each case will trigger the corresponding method in the corresponding controller for the corresponding usecase.
            case Constants.SEND_MSG:
                break;
            case Constants.CHANGE_PROFILE:
                break;
            case Constants.ACCEPT_FRIEND:
                friendPresenter.receiveConfirmation(content);
            case Constants.REQUEST_FRIEND:
                friendPresenter.receiveRequest(content);
                break;
            case Constants.REGISTER:
                loginPresenter.receiveConfirmation(content);
                break;

        }
    }

}
