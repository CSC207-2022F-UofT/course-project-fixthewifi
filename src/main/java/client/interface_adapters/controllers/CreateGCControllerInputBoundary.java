package client.interface_adapters.controllers;

public interface CreateGCControllerInputBoundary {
    /**
     * Creates a String (msg) then has ComManager send that message to the server.
     * (msg) contains Constants.RETRIEVE_FRIENDS_LIST and the users UID.
     */
    void getList();
    /**
     * Creates a String (msg) then has ComManager send that message to the server.
     * (msg) contains Constants.CREATE_GROUP_CHAT, admins UID, then all the other members UIDs
     * @param users String of non-admin users UIDs, separated by commas.
     */
    void create(String users);
}
