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
                {
                    if (isInteger(model.getPageState()))
                    {
                        sendMsgController.sendMsg(operand, Integer.parseInt(model.getPageState()));
                    }
                    else
                    {
                        System.out.println("Please send message when you are viewing a chat.");
                    }

                }

                case (REQUEST_FRIEND): friendController.requestFriend(Integer.parseInt(operand));
                case (ACCEPT_FRIEND): friendController.acceptFriend(Integer.parseInt(operand));
                case (REJECT_FRIEND): friendController.refuseFriend(Integer.parseInt(operand));
                case (DELETE_FRIEND): friendController.deleteFriend(Integer.parseInt(operand));

                case (VIEW_FRIENDS): displayFriends();
                case (VIEW_CHAT): displayChat(Integer.parseInt(operand));
                case (VIEW_PROFILE): displayMyProfile();
                case (VIEW_ALLCHAT): displayChats();

                case (LOGOUT): loginController.logout();
                case (DELETE_ACCOUNT): loginController.delete();
                case (CHANGE_NAME): chPrController.updateName(operand);
                case (CHANGE_DESC): chPrController.updateDescr(operand);

                case (SET_PIC): chPrController.setPic(operand);
                case (DEL_PIC): chPrController.delPic();
                case (RATING): {
                    String[] content = operand.split(" ", 2);
                    ratingController.rate(Integer.parseInt(content[0]), Integer.parseInt(content[1]));
                }
                case (HELP): help();
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
                """
                        If an instruction has no operands, put a space bar after the instruction.
                        HELP = $help
                        
                        Message operations:
                        SEND_CHAT = $send <content>
                        DELETE_CHAT = $del
                        EDIT_CHAT = $edt
                        
                        Sign in Sign out:
                        LOGIN = $lgn <uid> <password>
                        REGISTER = $reg <name> <password>
                        LOGOUT = $logout
                        DELETE_ACCOUNT = $del_account
                        
                        Friends:
                        REQUEST_FRIEND = $ref <friendUid>
                        ACCEPT_FRIEND = $acp <uid>
                        REJECT_FRIEND = $rej <uid>
                        DELETE_FRIEND = $dtf <uid>
                        
                        View info:
                        VIEW_CHAT = $cht <chatUid>
                        VIEW_FRIENDS = $vwf
                        VIEW_PROFILE = $vpr
                        
                        Change Profile:
                        CHANGE_NAME = $chn
                        CHANGE_DESC = $chd
                        SET_PIC = $stp
                        DEL_PIC = $dlp
                        RATING = $rate <uid> <rating>
                        """);
    }

    public void displayLoginPage()
    {
        System.out.println("please enter $reg <name> <password>: ");
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
