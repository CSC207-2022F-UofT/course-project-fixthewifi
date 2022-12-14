package client.interface_adapters.presenters;

import client.frameworks_and_drivers.Constants;
import client.interface_adapters.model.ModelInterface;

import java.util.Arrays;

public class EditDeleteMsgPresenter implements EditDeleteMsgPresenterInputBoundary
{
    private final ModelInterface model;

    public EditDeleteMsgPresenter(ModelInterface model)
    {
        this.model = model;
    }

    public void receiveMsg(String data)
    {
        String[] content = data.split(String.valueOf(Constants.SPR));
        model.editMsg(Integer.parseInt(content[0]), Integer.parseInt(content[1]), content[2]);
        model.notifyView("A message has been updated in chat uid = " + Integer.parseInt(content[0]));
    }


}
