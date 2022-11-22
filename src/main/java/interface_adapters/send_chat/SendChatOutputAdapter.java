package interface_adapters.send_chat;

import frameworks_and_drivers.communication_manager.IfComManager;
import interface_adapters.Constants;
import usecases.send_chat.SendChatInputModel;
import usecases.send_chat.SendChatOutputBoundary;
import usecases.send_chat.SendChatOutputModel;

import java.util.List;

public class SendChatOutputAdapter implements SendChatOutputBoundary
{
    private final IfComManager comManager;
    public SendChatOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendChat(SendChatOutputModel model)
    {
        String content = String.join(String.valueOf(Constants.CONTENT_SPR), String.valueOf(model.senderUid), String.valueOf(model.chatUid), model.content, model.time, String.valueOf(model.uid));
        for(List<String> AddressPair : model.chatMembersAddress)
        {
            comManager.send(AddressPair.get(0), Integer.parseInt(AddressPair.get(1)), content);
        }
    }
}
