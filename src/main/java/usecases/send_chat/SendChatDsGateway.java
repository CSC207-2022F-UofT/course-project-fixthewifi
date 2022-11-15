package usecases.send_chat;

public interface SendChatDsGateway
{
    void storeChat(int chatUid, int senderUid, String content, String time);
}
