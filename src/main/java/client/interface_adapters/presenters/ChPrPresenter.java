package client.interface_adapters.presenters;

import client.frameworks_and_drivers.Constants;
import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;

public class ChPrPresenter implements ChPrPresenterInputBoundary
{
    private final Model model;

    public ChPrPresenter(Model model)
    {
        this.model = model;
    }

    @Override
    public void setPic(String url)
    {
        model.setPageState("SET_PIC");
        String[] content = url.split(String.valueOf(Constants.SPR));
//        model.set(content[1]);
    }

    @Override
    public void delPic()
    {
        model.setPageState("DEL_PIC");
//        model.setSelfSetPic("None");
    }

    @Override
    public void updateName(String newname)
    {
        model.setPageState("UPDATE_NAME");
        String[] content = newname.split(String.valueOf(Constants.SPR));
        model.setSelfName(content[1]);
        model.notifyView("You change has been recorded.");

    }

    @Override
    public void updateDescr(String newdesc)
    {
        model.setPageState("UPDATE_DESC");
        String[] content = newdesc.split(String.valueOf(Constants.SPR));
        model.setSelfDescription(content[1]);
        model.notifyView("You change has been recorded.");
    }
}
