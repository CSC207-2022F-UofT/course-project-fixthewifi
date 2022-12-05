package client.interface_adapters.model.model_entities;

public class MessageFactory
{
    public static Message newMessage(int msgUid, int senderUid, String content, String time)
    {
        return new Message(msgUid, senderUid, content, time);
    }
}
