package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.controllers.*;

import client.interface_adapters.model.ChatNotFoundException;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;
import client.interface_adapters.model.UserNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConsoleView implements ModelObserver
{
    private static final String HELP = "$help";
    private static final String SEND_MSG = "$send";
    private static final String DELETE_CHAT = "$del";
    private static final String EDIT_CHAT = "$edt";
    private static final String LOGIN = "$lgn";
    private static final String REGISTER = "$reg";
    private static final String LOGOUT = "$logout";
    private static final String DELETE_ACCOUNT = "$del_account";
    private static final String REQUEST_FRIEND = "$ref";
    private static final String ACCEPT_FRIEND = "$acp";
    private static final String REJECT_FRIEND = "$rej";
    private static final String DELETE_FRIEND = "$dtf";
    private static final String CHANGE_NAME = "$chn";
    private static final String CHANGE_DESC = "$chd";
    private static final String SET_PIC = "$stp";
    private static final String DEL_PIC = "$dlp";
    private static final String RATING = "$rate";
    private static final String VIEW_PROFILE = "$vpr";
    private static final String VIEW_FRIENDS = "$vwf";
    private static final String VIEW_CHAT = "$chat";
    private static final String VIEW_ALLCHAT = "$chats";



    private final ModelInterface model;
    private final LoginControllerInputBoundary loginController;
    private final FriendControllerInputBoundary friendController;
    private final RatingControllerInputBoundary ratingController;

    private final ChPrControllerInputBoundary chPrController;
    private final SendMsgControllerInputBoundary sendMsgController;
    public ConsoleView(ModelInterface model,
                       LoginControllerInputBoundary loginController,
                       FriendControllerInputBoundary friendController,
                       ChPrControllerInputBoundary chPrController,
                       RatingControllerInputBoundary ratingController,
                       SendMsgControllerInputBoundary sendMsgController)

    {
        this.model = model;
        this.loginController = loginController;
        this.friendController = friendController;

        this.chPrController = chPrController;

        this.ratingController = ratingController;
        this.sendMsgController = sendMsgController;

    }

    /**
     * Make the view listen to inputs, loops as long as the program is running.
     */
    public void init()
    {
        try
        {
            System.out.println("Application initialized.");
            displayLoginPage();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                try
                {
                    // Reading data using readLine
                    String input = reader.readLine();
                    String[] content = input.split(" ", 2);
                    if (Objects.equals(model.getPageState(), "LOGIN_PAGE"))
                    {
                        sortLogin(content[0], content[1]);
                    } else if (Objects.equals(model.getPageState(), "MAIN_PAGE"))
                    {

                        sort(content[0], content[1]);
                    }
                    else{
                        //todo change all pages stuff work
                        sort(content[0], content[1]);
                    }
                }
                catch(ArrayIndexOutOfBoundsException exception)
                {
                    System.out.println("Please format your instruction correctly, such as adding a space after the instruction.");
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sorts the instruction, passes the operand into controllers.
     * @param operation The instruction to the program, starts with $
     * @param operand The input, such as name or password or both etc.
     */
    public void sort(String operation, String operand)
    {
        try
        {
            switch (operation)
            {
                case (SEND_MSG):
                    if (isInteger(model.getPageState()))
                    {
                        sendMsgController.sendMsg(operand, Integer.parseInt(model.getPageState()));
                    }
                    else
                    {
                        System.out.println("Please send message when you are viewing a chat.");
                    }
                    break;

                case (REQUEST_FRIEND):
                    friendController.requestFriend(Integer.parseInt(operand));
                    break;
                case (ACCEPT_FRIEND):
                    friendController.acceptFriend(Integer.parseInt(operand));
                    break;
                case (REJECT_FRIEND):
                    friendController.refuseFriend(Integer.parseInt(operand));
                    break;
                case (DELETE_FRIEND):
                    friendController.deleteFriend(Integer.parseInt(operand));
                    break;
                case (VIEW_FRIENDS):
                    displayFriends();
                    break;
                case (VIEW_CHAT):
                    displayChat(Integer.parseInt(operand));
                    break;
                case (VIEW_PROFILE):
                    displayMyProfile();
                    break;
                case (VIEW_ALLCHAT):
                    displayChats();
                    break;
                case (LOGOUT):
                    loginController.logout();
                    break;
                case (DELETE_ACCOUNT):
                    loginController.delete();
                    break;
                case (CHANGE_NAME):
                    chPrController.updateName(operand);
                    break;
                case (CHANGE_DESC):
                    chPrController.updateDescr(operand);
                    break;
                case (SET_PIC):
                    chPrController.setPic(operand);
                    break;
                case (DEL_PIC):
                    chPrController.delPic();
                    break;
                case (RATING):
                    String[] content = operand.split(" ", 2);
                    ratingController.rate(Integer.parseInt(content[0]), Integer.parseInt(content[1]));
                break;
                case (HELP):
                    help();
                    break;
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Please format your instruction correctly, such as adding a space after the instruction.");
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * A separate sort login method so that the user can only login or register at the start of the program.
     */
    public void sortLogin(String operation, String operand)
    {
        try
        {
            if (operation.equals(REGISTER))
            {
                String[] content = operand.split(" ");
                loginController.register(content[0], content[1]);
            } else if (operation.equals(LOGIN))
            {
                String[] content = operand.split(" ");
                loginController.login(Integer.parseInt(content[0]), content[1]);
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Something isn't right.");
        }

    }

    private void help()
    {
        System.out.println(
                        "If an instruction has no operands, put a space bar after the instruction." + "\n" +
                        "HELP = $help" + "\n\n" +
                        
                        "Message operations:" + "\n" +
                        "SEND_CHAT = $send <content>" + "\n" +
                        "DELETE_CHAT = $del" + "\n" +
                        "EDIT_CHAT = $edt" + "\n" +

                        "Sign in Sign out:" + "\n" +
                        "LOGIN = $lgn <uid> <password>" + "\n" +
                        "REGISTER = $reg <name> <password>" + "\n" +
                        "LOGOUT = $logout" + "\n" +
                        "DELETE_ACCOUNT = $del_account" + "\n\n" +
                        
                        "Friends:" + "\n" +
                        "REQUEST_FRIEND = $ref <friendUid>" + "\n" +
                        "ACCEPT_FRIEND = $acp <uid>" + "\n" +
                        "REJECT_FRIEND = $rej <uid>" + "\n" +
                        "DELETE_FRIEND = $dtf <uid>" + "\n" +
                        
                        "View info:" + "\n" +
                        "VIEW_CHAT = $cht <chatUid>" + "\n" +
                        "VIEW_FRIENDS = $vwf" + "\n" +
                        "VIEW_PROFILE = $vpr" + "\n" +
                        
                        "Change Profile:" + "\n" +
                        "CHANGE_NAME = $chn" + "\n" +
                        "CHANGE_DESC = $chd" + "\n" +
                        "SET_PIC = $stp" + "\n" +
                        "DEL_PIC = $dlp" + "\n" +
                        "RATING = $rate <uid> <rating>"
                        );
    }

    public void displayLoginPage()
    {
        System.out.println("please enter $reg <name> <password> or $lgn <uid> <password> to register or login: ");
    }

    public void displayUserProfile(int userUid)
    {
        System.out.println("===========Profile===========");
        System.out.println("uid: " + userUid);
        System.out.println("name: " + userUid);
        try {
            System.out.println("description: " + model.getDescription(userUid));
        } catch (UserNotFoundException e) {
            System.out.println("User not found.");
        }
    }

    public void displayChat(int chatUid)
    {
        model.setPageState(Integer.toString(chatUid));
        try {
            System.out.println(model.showChat(chatUid));
            System.out.println(model.printChatHistory(chatUid));
        } catch (ChatNotFoundException e) {
            System.out.println("Chat not found.");
        }
    }

    public void displayChats()
    {
        System.out.println(model.showChats());
    }

    public void displayFriends()
    {
        System.out.println(model.showFriends());
    }

    public void displayMyProfile()
    {
        System.out.println(model.showSelfProfile());
    }

    @Override
    public void update(String content)
    {
        System.out.println(content);
    }
}
