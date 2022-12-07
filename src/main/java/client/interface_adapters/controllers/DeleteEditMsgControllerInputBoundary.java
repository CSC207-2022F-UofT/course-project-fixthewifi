package client.interface_adapters.controllers;

public interface DeleteEditMsgControllerInputBoundary {

    public void deleteMsg(int msgUid, int chatUid);

    public void editMsg(String updatedContent, int msgUid, int chatUid);
}
