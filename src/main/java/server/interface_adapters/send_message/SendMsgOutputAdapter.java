package server.interface_adapters.send_message;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.send_message.SendMsgOutputBoundary;
import server.usecases.send_message.SendMsgOutputModel;

import java.util.List;

public class SendMsgOutputAdapter implements SendMsgOutputBoundary
{
    private final IfComManager comManager;
    public SendMsgOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendChat(SendMsgOutputModel model)
    {
        char spr = 30;
        String content = String.join(String.valueOf(spr), String.valueOf(model.msgUid), String.valueOf(model.senderUid), model.content, model.time, String.valueOf(model.chatUid), model.name);
        comManager.send(model.address, model.port, Constants.SEND_MSG+"#"+content);
    }
}
