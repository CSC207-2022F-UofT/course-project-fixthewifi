package server.usecases.send_message;

public class SendMsgInputModel
{
    public int senderUid;
    public int chatUid;
    public String content;

    public String time;

    public SendMsgInputModel(int senderUid, int chatUid, String content, String time)
    {
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.content = content;
        this.time = time;
    }
}
