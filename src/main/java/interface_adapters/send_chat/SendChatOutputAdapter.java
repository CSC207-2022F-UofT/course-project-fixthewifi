package interface_adapters.send_chat;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.send_chat.SendChatOutputBoundary;
import usecases.send_chat.SendChatOutputModel;

import java.util.List;

public class SendChatOutputAdapter implements SendChatOutputBoundary
{
    private IfComManager comManager;
    public SendChatOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendChat(SendChatOutputModel model)
    {
        char spr = 30;
        String content = String.join(String.valueOf(spr), model.content, model.time, String.valueOf(model.senderUid));
        for(List<String> AddressPair : model.chatMembersAddress)
        {
            comManager.send(AddressPair.get(0), Integer.parseInt(AddressPair.get(1)), content);
        }
    }
}