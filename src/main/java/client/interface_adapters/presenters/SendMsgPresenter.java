package client.interface_adapters.presenters;

import client.frameworks_and_drivers.Constants;
import client.interface_adapters.model.ModelInterface;

public class SendMsgPresenter implements SendMsgPresenterInputBoundary
{
    private final ModelInterface model;

    public SendMsgPresenter(ModelInterface model)
    {
        this.model = model;
    }

    public void receiveMsg(String data)
    {
        String[] content = data.split(String.valueOf(Constants.SPR));
        model.addMsg(Integer.parseInt(content[0]), Integer.parseInt(content[1]), content[2], content[3], Integer.parseInt(content[4]));
        model.notifyView(data);
    }
}
