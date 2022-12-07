package client.interface_adapters.presenters.change_profile;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;
import client.interface_adapters.presenters.FriendPresenterInputBoundary;

public class ChPrPresenter implements ChPrPresenterInputBoundary
{
    private final Model model;
    private final ConsoleView view;

    public ChPrPresenter(Model model, ConsoleView view)
    {
        this.model = model;
        this.view = view;
    }

    @Override
    public void setPic(String url) {
        model.setPageState("SET_PIC");
        String[] content = url.split(String.valueOf(Constants.SPR));
        model.setSelfSetPic(content[1]);
        view.displayMyProfile();

    }

    @Override
    public void delPic() {
        model.setPageState("DEL_PIC");
        model.setSelfSetPic("None");
        view.displayMyProfile();

    }

    @Override
    public void updateName(String newname) {
        model.setPageState("UPDATE_NAME");
        String[] content = newname.split(String.valueOf(Constants.SPR));
        model.setSelfName(content[1]);
        view.displayMyProfile();

    }

    @Override
    public void updateDescr(String newdesc) {
        model.setPageState("UPDATE_DESC");
        String[] content = newdesc.split(String.valueOf(Constants.SPR));
        model.setSelfDesc(content[1]);
        view.displayMyProfile();
    }
}
