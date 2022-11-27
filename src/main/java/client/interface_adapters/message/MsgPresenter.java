package client.interface_adapters.message;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.Constants;
import client.usecases.message.MessageOutputBoundary;

public class MsgPresenter implements MessageOutputBoundary
{
    private final IfComManager comManager;
    public MsgPresenter(IfComManager comManager)
    {
        this.comManager = comManager;
    }

    @Override
    public void sendMsg(int senderUid, int chatUid, String content, String time)
    {
        String toSend = String.join(String.valueOf(Constants.SPR), String.valueOf(senderUid), String.valueOf(chatUid), content, time);
        comManager.send("1.2.7.0.0.1",4444, toSend);
    }


}
