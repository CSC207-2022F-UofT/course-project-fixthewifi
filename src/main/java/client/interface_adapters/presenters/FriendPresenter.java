package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;

public class FriendPresenter implements FriendPresenterInputBoundary
{
    private final ModelInterface model;


    public FriendPresenter(ModelInterface model)
    {
        this.model = model;
    }


    @Override
    public void receiveRequest(String data)
    {
        String[] content = data.split(" ");

        if (Integer.parseInt(content[0]) == 1)
        {
            model.notifyView("Requested friend Successfully.");
        }
        else if (Integer.parseInt(content[0]) == 0)
        {
            model.notifyView("Request friend failed. You might be requesting someone who is already your friend, " + "\n" +
                    "somneone who you have already requested. (Please have at least two clients open to use this feature.)");
        }
        else
        {
            model.notifyView("New request from ui: " + Integer.parseInt(content[1]) + ", name: " + content[2]);
        }
    }

    @Override
    public void receiveAccept(String data)
    {
        char SPR = 30;
        model.setPageState("FRIEND_ACCEPT");
        String[] content =data.split(" ", 2);
        if (Integer.parseInt(content[0]) == 1)
        {
            String[] friendData = content[1].split(String.valueOf(SPR));
            boolean online = friendData[4].equals("T");
            model.addFriend(Integer.parseInt(friendData[0]), friendData[1], friendData[2], Double.parseDouble(friendData[3]), online);
            model.notifyView("You are now friend with " + friendData[1] + ", uid: " + Integer.parseInt(friendData[0]));
        }
        else if (Integer.parseInt(content[0]) == 0){
            model.notifyView("Rejected by" + content[1] + content[2]);
        }
        else if (Integer.parseInt(content[0]) == 2)
        {
            String[] chatData = content[1].split(String.valueOf(SPR));
            model.addPrivateChat(Integer.parseInt(chatData[0]), chatData[1], chatData[2], Integer.parseInt(chatData[3]));
        }
    }

    @Override
    public void receiveDelete(String data) {
        String[] content = data.split( " ");
        if (Integer.parseInt(content[0]) == 1){
            model.notifyView("Received deletion from " + content[1]);
            model.deleteFriend(Integer.parseInt(content[1]));
            model.deletePrivateChat(Integer.parseInt(content[1]));
        }
        else if (Integer.parseInt(content[0]) == 3){
            model.notifyView("Failed to delete friend.");
        }
    }

    @Override
    public void receiveView(String data) {

    }
}
