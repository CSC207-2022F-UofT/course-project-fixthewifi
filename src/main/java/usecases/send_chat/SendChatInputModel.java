package usecases.send_chat;

public class SendChatInputModel
{
    public int senderUid;
    public int chatUid;
    public String content;

    public String time;

    public SendChatInputModel(int senderUid, int chatUid, String content, String time)
    {
        this.content = content;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.time = time;
    }
}
