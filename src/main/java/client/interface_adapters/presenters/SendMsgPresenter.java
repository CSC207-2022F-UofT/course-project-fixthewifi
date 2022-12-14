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
        if (isInteger(model.getPageState()))
        {
            if (Integer.parseInt(model.getPageState()) == Integer.parseInt(content[4]))
            {
                model.notifyView("Message " + Integer.parseInt(content[0]) + " by " + content[5] + " on " +  content[3] + ":");
                model.notifyView("                   " + content[2]);
                model.notifyView("");
            }
        }
    }

    private boolean isInteger(String s)
    {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
