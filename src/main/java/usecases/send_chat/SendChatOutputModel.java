package usecases.send_chat;

public class SendChatOutputModel
{
    int senderUid;
    int chatUid;
    String content;
    String time;
    public SendChatOutputModel(int senderUid, int chatUid, String content, String time)
    {
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.content = content;
        this.time = time;
    }

}
