package client.interface_adapters.presenters;

import client.interface_adapters.Constants;
import client.interface_adapters.model.Model;

public class MsgPresenter implements MsgPresenterInputBoundary
{
    private final Model model;

    public MsgPresenter(Model model)
    {
        this.model = model;
    }

    public void receiveMsg(String data)
    {
        String[] content = data.split(String.valueOf(Constants.SPR));
//        model.storeChatMsg(Integer.parseInt(content[2]), Integer.parseInt(content[0]), Integer.parseInt(content[1]), content[3], content[4]);
    }
}
