package client.interface_adapters.message;

import client.interface_adapters.Constants;
import client.usecases.message.MessageInputBoundary;

public class MsgController implements MsgControllerInputBoundary
{
    private final MessageInputBoundary interactor;

    public MsgController(MessageInputBoundary interactor)
    {
        this.interactor = interactor;
    }

    @Override
    public void sendMsg(String content, int ChatUid)
    {
        interactor.sendMsg(content, ChatUid);
    }

    @Override
    public void receiveMsg(String toDissect)
    {
        String[] content = toDissect.split(String.valueOf(Constants.SPR));
        interactor.receiveMsg(Integer.parseInt(content[0]), Integer.parseInt(content[1]), Integer.parseInt(content[2]), content[3], content[4]);
    }
}
