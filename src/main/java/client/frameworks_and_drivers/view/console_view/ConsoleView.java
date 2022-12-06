package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.controllers.FriendControllerInputBoundary;
import client.interface_adapters.controllers.LoginControllerInputBoundary;
import client.interface_adapters.controllers.MsgControllerInputBoundary;
import client.interface_adapters.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConsoleView
{
    private final Model model;
    private final LoginControllerInputBoundary loginController;
    private final FriendControllerInputBoundary friendController;

    public ConsoleView(Model model,
                       LoginControllerInputBoundary loginController,
                       FriendControllerInputBoundary friendController)
    {
        this.model = model;
        this.loginController = loginController;
        this.friendController = friendController;
    }

    public void init()
    {
        try
        {
            System.out.println("Application initialized.");
            displayLoginPage();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                // Reading data using readLine
                String input = reader.readLine();
                String[] content = input.split(" ", 2);

                if (Objects.equals(model.getPageState(), "LOGIN_PAGE"))
                {
                    sortLogin(content[0], content[1]);
                } else
                {
                    sort(content[0], content[1]);
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void sort(String operation, String operand)
    {
        if (model.getPageState().startsWith("CHAT"))
        {

        }
        else
        {
            switch (operation)
            {
                case(InstructionSet.VIEW_CHAT):
                    displayChat(Integer.parseInt(operand));
                    break;

                case(InstructionSet.VIEW_FRIEND):
                    displayFriends();
                    break;

                case(InstructionSet.REQUEST_FRIEND):
                    friendController.requestFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.ACCEPT_FRIEND):
                    friendController.acceptFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.DELETE_FRIEND):
                    friendController.deleteFriend(Integer.parseInt(operand));
                    break;
            }
        }
    }

    private void displayFriends() 
    {
    }

    public void sortLogin(String operation, String operand)
    {
        if (operation.equals(InstructionSet.REGISTER))
        {
            String[] content = operand.split(" ");
            loginController.register(content[0], content[1]);
        }
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
        System.out.println("description: " + model.getDescription(userUid));
    }

    public void displayChat(int chatUid)
    {
        model.setPageState(Integer.toString(chatUid));
    }

    public void displayNewRequest(int parseInt, String s) {
    }

    public void displayConfirmation(int parseInt, String s)
    {
        System.out.println("You have a new friend, uid: " + parseInt + ", name: " + s);
    }

    public void displayLoginSuccess()
    {
        System.out.println("Login successful.");
    }

    public void displayLoginFail()
    {
        System.out.println("Login failed.");
    }
}
