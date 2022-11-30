package server.interface_adapters.send_message;

import server.usecases. send_message.SendMsgInputBoundary;
import server.usecases.send_message.SendMsgInputModel;

public class SendMsgController
{
    char CONTENT_SPR = 30;
    final SendMsgInputBoundary useCase;

    public SendMsgController(SendMsgInputBoundary useCase)
    {
        this.useCase = useCase;
    }

    public void sendChat(String msg)
    {
        String[] content = msg.split(String.valueOf(CONTENT_SPR));
        SendMsgInputModel model = new SendMsgInputModel(Integer.parseInt(content[0]), Integer.parseInt(content[1]), content[2], content[3]);
        useCase.SendChat(model);
    }

}