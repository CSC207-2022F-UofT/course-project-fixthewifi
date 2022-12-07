package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.controllers.FriendControllerInputBoundary;
import client.interface_adapters.controllers.LoginControllerInputBoundary;

import client.interface_adapters.controllers.change_profile.ChPrControllerInputBoundary;

import client.interface_adapters.controllers.MsgControllerInputBoundary;
import client.interface_adapters.controllers.RatingControllerInputBoundary;

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
    private final RatingControllerInputBoundary ratingController;

    private final ChPrControllerInputBoundary chPrController;
    public ConsoleView(Model model,
                       LoginControllerInputBoundary loginController,
                       FriendControllerInputBoundary friendController,

                       ChPrControllerInputBoundary chPrController,

                       RatingControllerInputBoundary ratingController)

    {
        this.model = model;
        this.loginController = loginController;
        this.friendController = friendController;

        this.chPrController = chPrController;

        this.ratingController = ratingController;

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


        if (model.getPageState().startsWith("CHAT"))
        {

        }
        else
        {

            System.out.println("before swich console view");
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
                    friendController.accept(Integer.parseInt(operand));
                    break;

                case(InstructionSet.VIEW_PROFILE):
                    displayMyProfile();
                    System.out.println("VIEW_PROFILE console view");
                    break;

                case(InstructionSet.CHANGE_NAME):
                    chPrController.updateName(operand);

                    System.out.println("change name console view");
                    break;
                case(InstructionSet.CHANGE_DESC):
                    chPrController.updateDescr(operand);

                    System.out.println("change desc console view");
                    break;
                case(InstructionSet.SET_PIC):
                    chPrController.setPic(operand);

                    System.out.println("set pic console view");
                    break;
                case(InstructionSet.DEL_PIC):
                    chPrController.delPic();

                    System.out.println("del pic console view");
                    break;


                case(InstructionSet.RATING):
                    String[] content = operand.split(" ", 2);
                    ratingController.rate(Integer.parseInt(content[0]), Integer.parseInt(content[1]));
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

    public void displayConfirmation(int parseInt, String s) {
    }

    public void displayLoginSuccess()
    {
        System.out.println("Login successful.");
    }

    public void displayMyProfile() {
        System.out.println("My Profile");
        System.out.println(model.getProfileInfo());
    }

    public void displayLoginFail()
    {
        System.out.println("Login failed.");
    }

    // Rating Stuff
    public void displayRatingSuccess()
    {
        System.out.println("Rating successful.");
    }

    public void displayRatingFail()
    {
        System.out.println("Rating failed.");
    }

    public void displayRating(int userUid)
    {
        System.out.println("===========Rating===========");
        System.out.println("uid: " + userUid);
        System.out.println("name: " + userUid);
//        System.out.println("description: " + model.getDescription(userUid));
//        System.out.println("Rating: " + model.getRating(userUid));
    }
}
