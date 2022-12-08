package server.usecases.send_message;

import java.util.List;

public class SendMsgOutputModel
{
    public List<List<String>> chatMembersAddress;
    public int msgUid;
    public int senderUid;
    public int chatUid;
    public String content;
    public String time;

    public SendMsgOutputModel(List<List<String>> chatMembersAddress, int msgUid, int senderUid, int chatUid, String content, String time)
    {
        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.chatMembersAddress = chatMembersAddress;
        this.content = content;
        this.time = time;
    }

}
