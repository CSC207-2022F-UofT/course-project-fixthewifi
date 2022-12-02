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
        model.setPageState("FRIEND_REQUEST");
        String[] content = data.split(String.valueOf(Constants.SPR));

        view.displayNewRequest(Integer.parseInt(content[0]), content[1]);
    }

    @Override
    public void receiveConfirmation(String data)
    {
        String[] content = data.split(" ");
        view.displayConfirmation(Integer.parseInt(content[0]), content[1]);

    }
}