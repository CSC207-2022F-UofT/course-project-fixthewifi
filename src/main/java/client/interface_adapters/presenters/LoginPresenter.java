package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;

public class LoginPresenter
{
    private final Model model;
    private final ConsoleView view;
    char SPR = 30;


    public LoginPresenter(Model model, ConsoleView view)
    {
        this.model = model;
        this.view = view;
    }

    public void receiveConfirmation(String data)
    {
        String[] content = data.split(String.valueOf(SPR));
        if (content[0].equals("success"))
        {
            model.setSelfStatus(true);
            view.displayLoginSuccess();
            model.setSelfUid(Integer.parseInt(content[1]));
            model.setPageState("MAIN_PAGE");
        }
        else
        {
            view.displayLoginFail();
        }
    }
}
