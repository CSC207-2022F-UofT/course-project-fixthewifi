package server.frameworks_and_drivers;
import server.frameworks_and_drivers.communication_manager.ComManagerUser;
import server.interface_adapters.friend.input.AcceptFriendController;
import server.interface_adapters.friend.input.RequestFriendController;
import server.interface_adapters.login.LoginController;
import server.interface_adapters.register.RegisterController;
import server.interface_adapters.send_message.SendMsgController;
import server.interface_adapters.change_rating.SendRatingController;

public class InputSorter implements ComManagerUser
{
//    private final SendMsgController sendMsgController;
//    private final LoginController loginController;
    private final RequestFriendController requestFriendController;
    private final AcceptFriendController acceptFriendController;
    private final RegisterController registerController;
    private final SendRatingController sendRatingController;

    public InputSorter(RequestFriendController requestFriendController, 
                        AcceptFriendController acceptFriendController, 
                        RegisterController registerController,
                        SendRatingController sendRatingController)
    {
        //TODO: pass all of the controllers into here
        //this.sendMsgController = sendMsgController;
        //this.loginController = loginController;
        this.registerController = registerController;
        this.requestFriendController = requestFriendController;
        this.acceptFriendController = acceptFriendController;
        this.sendRatingController = sendRatingController;
    }

    /**
     * When a message is received, onMsg will be triggered by comManager.
     @param msg The received message.
     */
    @Override
    public void onMsg(String msg, String peerIp)
    {
        String[] splitMsg = msg.split("#", 2);
        int useCaseConstant = Integer.parseInt(splitMsg[0]);
        String content = splitMsg[1];
        switch (useCaseConstant)
        {
            //TODO: each case will trigger the corresponding method in the corresponding controller for the corresponding usecase.
            case Constants.SEND_MSG:
//                sendMsgController.sendChat(content);
                break;
            case Constants.CHANGE_PROFILE:
                break;
            case Constants.GROUP_CHAT:
                break;
            case Constants.LOGIN:
//                loginController.login(content);
                break;
            case Constants.REGISTER:
                registerController.register(content, peerIp);
                break;
            case Constants.REQUEST_FRIEND:
                requestFriendController.requestFriend(content);
                break;
            case Constants.ACCEPT_FRIEND:
                acceptFriendController.acceptFriend(content);
                break;
            case Constants.SEND_RATING:
                String[] splitContent = content.split(" ");
                sendRatingController.sendRating(Integer.parseInt(splitContent[0]), Integer.parseInt(splitContent[1]),
                        Integer.parseInt(splitContent[2]));
                break;


        }
    }

}
