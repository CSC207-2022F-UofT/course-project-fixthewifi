package interface_adapters.send_chat;

import interface_adapters.Constants;
import usecases.send_chat.SendChatInputBoundary;
import usecases.send_chat.SendChatInputModel;

public class SendChatController
{
    final SendChatInputBoundary useCase;

    public SendChatController(SendChatInputBoundary useCase)
    {
        this.useCase = useCase;
    }

    public void sendChat(String msg)
    {
        String[] content = msg.split(String.valueOf(Constants.CONTENT_SPR));
        SendChatInputModel model = new SendChatInputModel(Integer.parseInt(content[0]), Integer.parseInt(content[1]), content[2], content[3]);
        useCase.SendChat(model);
    }

}
