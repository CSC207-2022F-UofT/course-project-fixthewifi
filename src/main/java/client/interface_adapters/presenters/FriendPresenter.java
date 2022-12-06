package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

import java.util.ArrayList;
import java.util.List;

public class FriendPresenter implements FriendPresenterInputBoundary
{
    private final Model model;
    private final ConsoleView view;

    public FriendPresenter(Model model, ConsoleView view)
    {
        this.model = model;
        this.view = view;
    }


    @Override
    public void receiveRequest(String data)
    {
        System.out.println("RECEIVEREQUEST " + data);
        String[] content = data.split(" ");

        if (Integer.parseInt(content[0]) == 1)
        {
            System.out.println("Requested successfully.");
        }
        else if (Integer.parseInt(content[0]) == 0)
        {
            System.out.println("Request failed. UID is not found or already in your friend list or you requested the same person twice.");
        }
        else
        {
            view.displayNewRequest(Integer.parseInt(content[1]), content[2]);
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
            view.displayConfirmation(Integer.parseInt(friendData[0]), friendData[1]);
        }
        else if (Integer.parseInt(content[0]) == 0){
            System.out.println("Your friend request to " + content[1] + content[2] + " was declined");
        }
        else if (Integer.parseInt(content[0]) == 2)
        {
            String[] chatData = content[1].split(String.valueOf(SPR));
            model.addPrivateChat(Integer.parseInt(chatData[0]), chatData[1], chatData[2], Integer.parseInt(chatData[3]));
            System.out.println(model);
        }
    }

    @Override
    public void receiveDelete(String data) {
        String[] content = data.split( " ");
        if (Integer.parseInt(content[0]) == 1){
            System.out.println("You have successfully deleted friend:" + content[1]);
        }
        else if (Integer.parseInt(content[0]) == 3){
            System.out.println("Fail to delete friend. You may entered a wrong uid.");
        }
        else if (Integer.parseInt(content[0]) == 2){
            System.out.println("Your friend request to " + content[1]+ " " + content[2] +" was successful.");
        }
    }

    @Override
    public void receiveView(String data) {
        String[] content = data.split( " ");
        System.out.println("Your friend are: <Name> <UID>");
        int content_length = content.length;
        int i = 0;
        while (i != content_length - 1){
            System.out.println(content[i] + " " + content[i + 1]);
            i += 2;
        }
    }
}
