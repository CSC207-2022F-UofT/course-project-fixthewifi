package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

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
            System.out.println("Requested successfully.");
        }
        else if (Integer.parseInt(content[0]) == 0)
        {
            System.out.println("Request failed.");
        }
        else
        {
            model.addRequester(Integer.parseInt(content[1]), content[2]);
            view.displayNewRequest(Integer.parseInt(content[1]), content[2]);
        }
    }

    @Override
    public void receiveAccept(String data)
    {
        model.setPageState("FRIEND_ACCEPT");
        String[] content =data.split(" ");
        if (Integer.parseInt(content[0]) == 1){
            view.displayConfirmation(Integer.parseInt(content[0]), content[1]);

        }
        else if (Integer.parseInt(content[0]) == 2){
            System.out.println("Your friend request to " + content[1] + " was declined");
        }
    }

    @Override
    public void receiveDelete(String data) {

    }

    @Override
    public void receiveView(String data) {

    }
}
