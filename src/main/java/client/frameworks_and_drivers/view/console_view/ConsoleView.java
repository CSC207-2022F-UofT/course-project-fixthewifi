package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.controllers.FriendControllerInputBoundary;
import client.interface_adapters.controllers.LoginControllerInputBoundary;

import client.interface_adapters.controllers.change_profile.ChPrControllerInputBoundary;

import client.interface_adapters.controllers.RatingControllerInputBoundary;

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
    private final RatingControllerInputBoundary ratingController;

    private final ChPrControllerInputBoundary chPrController;
    public ConsoleView(Model model,
                       LoginControllerInputBoundary loginController,
                       FriendControllerInputBoundary friendController,
                       CreateGCControllerInputBoundary create_gc_controller,
                       ChPrControllerInputBoundary chPrController,
                       RatingControllerInputBoundary ratingController) {
        this.model = model;
        this.loginController = loginController;
        this.friendController = friendController;

        this.chPrController = chPrController;

        this.ratingController = ratingController;

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

                    System.out.println("spliting console view");
                    if (Objects.equals(model.getPageState(), "LOGIN_PAGE"))
                    {
                        sortLogin(content[0], content[1]);
                    } else if (Objects.equals(model.getPageState(), "MAIN_PAGE"))
                    {

                        System.out.println("sort i console view");
                        sort(content[0], content[1]);
                    }
                    else{
                        //todo change all pages stuff work
                        System.out.println("sort i jyst addd console view");
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

    public void sort(String operation, String operand)  {

        System.out.println("sort start console view");
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

                case(InstructionSet.REQUEST_FRIEND):
                    friendController.requestFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.ACCEPT_FRIEND):
                    friendController.acceptFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.REJECT_FRIEND):
                    friendController.refuseFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.DELETE_FRIEND):
                    friendController.deleteFriend(Integer.parseInt(operand));
                    break;

                case(InstructionSet.VIEW_FRIEND):
                    displayFriends();
                    break;

                case(InstructionSet.LOGOUT):
                    loginController.logout();
                    break;

                case(InstructionSet.DELETE_ACCOUNT):
                    loginController.delete();
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
        } else if (operation.equals(InstructionSet.LOGIN))
        {
            String[] content = operand.split(" ");
            loginController.login(Integer.parseInt(content[0]), content[1]);
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

    public void displaySuccess_RequestFriend(){
        System.out.println("Friend request has been sent successfully.");
    }

    public void displayFailure_RequestFriend(){
        System.out.println("Friend request was failed.\n" +
                "UID is not found or already in your friend list or you requested the same person twice.\n" +
                "Please check it again.");
    }

    public void displayConfirmation_AcceptFriend(int parseInt, String s)
    {
        System.out.println("You have a new friend, uid: " + parseInt + ", name: " + s);
    }

    public void displayRejection_AcceptFriend(String s1, String s2){
        System.out.println("Your friend request had been rejected by: " + s1 + s2);
    }

    public void displaySuccess_DeleteFriend(String s){
        System.out.println("You have successfully deleted friend:" + s);
    }

    public void displayFailure_DeleteFriend(){
        System.out.println("Fail to delete friend.\nYou may entered a wrong uid.\nPlease check it again.");
    }

    public void displayDeletion_DeleteFriend(String requesterName, String requesterid){
        System.out.println("Your friend" + requesterid + "-" +  requesterName + "has delete you as friend.");
    }

    public void displayViewFriend(String s){
        String[] content = s.split( " ");
        System.out.println("Your friend are: <Name>-<UID>\n");
        int content_length = content.length;
        int i = 0;
        while (i != content_length - 1) {
            System.out.println(content[i] + "-" + content[i + 1]);
            i += 2;
        }
    }

    public void displayLoginSuccess()
    {
        System.out.println("Login successful.");
    }

    public void displayMyProfile() {
        System.out.println("My Profile");
        System.out.println(model);
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
