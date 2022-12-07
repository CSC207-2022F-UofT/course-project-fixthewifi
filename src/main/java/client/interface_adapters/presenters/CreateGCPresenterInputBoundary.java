package client.interface_adapters.presenters;

public interface CreateGCPresenterInputBoundary {
    /**
     * Parses the server response message to call the console view.
     * Calls ConsoleView.displayGCCreation() to print the list of the
     * users friends for selection purposes.
     * @param users string contains admins UID, followed by all of their UIDs and usernames
     *              each separated by Constants.SPR
     */
    void displayFriendsList(String users);

    /**
     * Parses the server response message to update the model and may call the console view.
     * Updates the model to add a new group chat, and iff the user is the admin,
     * also informs them of the successful creation.
     * @param users String of admins UID, followed by other members UIDs, separated by Constants.SPR
     */
    void createGC(String users);
}
