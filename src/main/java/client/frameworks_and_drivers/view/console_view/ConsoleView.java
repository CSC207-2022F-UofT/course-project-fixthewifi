package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.Constants;
import client.interface_adapters.controllers.*;
import client.interface_adapters.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class ConsoleView
{
    private final Model model;
    private final LoginControllerInputBoundary loginController;
    private final FriendControllerInputBoundary friendController;
    private final CreateGCControllerInputBoundary create_gc_controller;


    public ConsoleView(Model model,
                       LoginControllerInputBoundary loginController,
                       FriendControllerInputBoundary friendController,
                       CreateGCControllerInputBoundary create_gc_controller)
    {
        this.model = model;
        this.loginController = loginController;
        this.friendController = friendController;
        this.create_gc_controller = create_gc_controller;
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
                try
                {
                    // Reading data using readLine
                    String input = reader.readLine();
                    String[] content = input.split(" ", 2);

                    if (Objects.equals(model.pageState, "LOGIN_PAGE"))
                    {
                        sortLogin(content[0], content[1]);
                    } else if (Objects.equals(model.pageState, "MAIN_PAGE"))
                    {
                        sort(content[0], content[1]);
                    }
                }
                catch(ArrayIndexOutOfBoundsException exception)
                {
                    System.out.println("Are you sure about that, son?");
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
        if (model.pageState.startsWith("CHAT"))
        {

        }
        else
        {
            switch (operation)
            {
                case(InstructionSet.VIEW_CHAT):
                    displayChat(Integer.parseInt(operand));
                    break;

                case(InstructionSet.VIEW_FRIENDS):
                    displayFriends();
                    break;

                case(InstructionSet.REQUEST_FRIEND):
                    friendController.request(Integer.parseInt(operand));
                    break;

                case(InstructionSet.ACCEPT_FRIEND):
                    friendController.accept(model.friendRequester);
                    break;

                case(InstructionSet.CREATE_GROUP_CHAT):
                    create_gc_controller.getList();
                    break;

                case(InstructionSet.SELECT_USERS):
                    create_gc_controller.create(operand);

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

    public void displayConfirmation(int parseInt, String s) {
    }

    public void displayLoginSuccess()
    {
        System.out.println("Login successful.");
    }

    public void displayLoginFail()
    {
        System.out.println("Login failed.");
    }

    /**
     * Lists the users friends in console for them to select from.
     * @param users ArrayList where each String contains the users UID then
     *              their username separated by Constants.SPR.
     */
    public void displayGCCreation(ArrayList<String> users) {
        System.out.println("=====Select Users by UID to Add=====");
        System.out.println("------------------------------------");
        System.out.println("========username || UID=============");
        for (String x : users){
            String[] user = x.split(String.valueOf(Constants.SPR));
            System.out.println(user[1] + "  ||  " + user[0]);
        }
    }

    /**
     * Prints a confirmation method to the admin of the GroupChat to confirm its confirmation.
     */
    public void displayGCConfirmation(){
        System.out.println("Your GroupChat has been created.");
    }
}
