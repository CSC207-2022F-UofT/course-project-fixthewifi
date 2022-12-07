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
        String[] content = data.split(" ");

        if (Integer.parseInt(content[0]) == 1)
        {
            view.displaySuccess_RequestFriend();
        }
        else if (Integer.parseInt(content[0]) == 0)
        {
            view.displayFailure_RequestFriend();
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
            view.displayConfirmation_AcceptFriend(Integer.parseInt(friendData[0]), friendData[1]);
        }
        else if (Integer.parseInt(content[0]) == 0){
            view.displayRejection_AcceptFriend(content[1], content[2]);
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
            view.displaySuccess_DeleteFriend(content[1]);
            model.deleteFriend(Integer.parseInt(content[1]));
            model.deletePrivateChat(Integer.parseInt(content[1]));
            System.out.println(model);
        }
        else if (Integer.parseInt(content[0]) == 3){
            view.displayFailure_DeleteFriend();
        }
    }

    @Override
    public void receiveView(String data) {
        view.displayViewFriend(data);
    }
}
