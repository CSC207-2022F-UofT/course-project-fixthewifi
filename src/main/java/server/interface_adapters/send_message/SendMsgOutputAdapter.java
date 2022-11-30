package server.interface_adapters.send_message;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.send_message.SendMsgOutputBoundary;
import server.usecases.send_message.SendMsgOutputModel;

import java.util.List;

public class SendMsgOutputAdapter implements SendMsgOutputBoundary
{
    private IfComManager comManager;
    public SendMsgOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendChat(SendMsgOutputModel model)
    {
        char spr = 30;
        String content = String.join(String.valueOf(spr), String.valueOf(model.msgUid), String.valueOf(model.senderUid), String.valueOf(model.chatUid), model.content, model.time, String.valueOf(model.senderUid));
        for(List<String> AddressPair : model.chatMembersAddress)
        {
            comManager.send(AddressPair.get(0), Integer.parseInt(AddressPair.get(1)), Constants.SEND_MSG+"#"+content);
        }
    }
}
