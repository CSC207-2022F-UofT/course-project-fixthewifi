package client.frameworks_and_drivers;
import client.frameworks_and_drivers.communication_manager.ComManagerUser;
import client.interface_adapters.presenters.*;

import client.interface_adapters.presenters.ChPrPresenterInputBoundary;


public class InputSorter implements ComManagerUser
{
    private static final int SEND_MSG = 0;
    private static final int CHANGE_PROFILE = 1;
    private static final int GROUP_CHAT = 2;
    private static final int LOGIN = 3;
    private static final int RATING = 4;
    private static final int EDIT_MSG = 5;
    private static final int FRIEND = 6;
    private static final int REGISTER = 7;
    private static final int REQUEST_FRIEND = 8;
    private static final int ACCEPT_FRIEND = 9;
    private static final int DELETE_MSG = 55;
    private static final int DELETE_FRIEND = 69;


    private static final int UPDATE_DESC = 110;
    private static final int UPDATE_NAME = 111;
    private static final int SET_PIC = 112;
    private static final int DEL_PIC = 113;
    private static final int FAIL=114;

    private final FriendPresenterInputBoundary friendPresenter;
    private final LoginPresenterInputBoundary loginPresenter;

    private final ChPrPresenterInputBoundary chPrPresenter;
    private final RatingPresenterInputBoundary ratingPresenter;

    private final SendMsgPresenterInputBoundary msgPresenter;
    private final CreateGCPresenterInputBoundary groupChatPresenter;
    public InputSorter(FriendPresenterInputBoundary friendPresenter,
                       LoginPresenterInputBoundary loginPresenter,
                       ChPrPresenterInputBoundary chPrPresenter,
                       RatingPresenterInputBoundary ratingPresenter,
                       SendMsgPresenterInputBoundary msgPresenter,
                       CreateGCPresenterInputBoundary groupChatPresenter)
    {
        this.friendPresenter = friendPresenter;
        this.loginPresenter = loginPresenter;
        this.groupChatPresenter = groupChatPresenter;

        this.chPrPresenter= chPrPresenter;
        this.ratingPresenter = ratingPresenter;
        this.msgPresenter = msgPresenter;

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
            case SEND_MSG:
                msgPresenter.receiveMsg(content);
                break;
            case CHANGE_PROFILE:
                break;
            case ACCEPT_FRIEND:
                friendPresenter.receiveAccept(content);
                break;
            case REQUEST_FRIEND:
                friendPresenter.receiveRequest(content);
                break;
            case REGISTER:
                loginPresenter.receiveRegisterConfirmation(content);
                break;
            case LOGIN:
                loginPresenter.receiveLoginConfirmation(content);
                break;
            case DELETE_FRIEND:
                friendPresenter.receiveDelete(content);
                break;
            case UPDATE_NAME:
                chPrPresenter.updateName(content);
                break;
            case UPDATE_DESC:
                chPrPresenter.updateDescr(content);
                break;
            case SET_PIC:
                chPrPresenter.setPic(content);
                break;
            case DEL_PIC:
                chPrPresenter.delPic();
                break;
            case RATING:
                ratingPresenter.receiveConfirmation(content);
                break;
            case Constants.RETRIEVE_FRIENDS_LIST:
                groupChatPresenter.displayFriendsList(content);
                break;
            case Constants.GROUP_CHAT:
                groupChatPresenter.createGC(content);
        }
    }

}
