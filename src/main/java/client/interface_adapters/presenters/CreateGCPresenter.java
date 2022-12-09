package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;
import java.util.ArrayList;

public class CreateGCPresenter implements CreateGCPresenterInputBoundary{
    private final Model model;
    private final ConsoleView view;

    public CreateGCPresenter(Model model, ConsoleView view)
    {
        this.model = model;
        this.view = view;
    }

    /**
     * Parses the server response message to call the console view.
     * Calls ConsoleView.displayGCCreation() to print the list of the
     * users friends for selection purposes.
     * @param users string contains admins UID, followed by all of their UIDs and usernames
     *              each separated by Constants.SPR
     */
    @Override
    public void displayFriendsList(String users) {
        String[] sep_str = users.split(String.valueOf(Constants.SPR)); // separated string into list
        ArrayList<String> formatted_users = new ArrayList<>();

        for(int i = 0; i < sep_str.length; i += 2){
            String s = String.valueOf(sep_str[i]) + Constants.SPR + sep_str[i + 1];
            formatted_users.add(s);
        }
        model.setPageState("GROUPCHAT_CREATION");
        view.displayGCCreation(formatted_users);

    }

    /**
     * Parses the server response message to update the model and may call the console view.
     * Updates the model to add a new group chat, and iff the user is the admin,
     * also informs them of the successful creation.
     * @param users String of admins UID, followed by other members UIDs, separated by Constants.SPR
     */
    @Override
    public void createGC(String users) {
        String[] split = users.split(String.valueOf(Constants.SPR));
        //this.model.createGC();
        // if (this.model.getSelfUid() == Integer.parseInt(split[0])) {
        //      this.view.displayGCConfirmation()
    }
}
