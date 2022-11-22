package usecases.send_chat;

import java.util.List;

public class SendChatOutputModel
{
    public int uid;
    public List<List<String>> chatMembersAddress;
    public int senderUid;

    public int chatUid;
    public String content;
    public String time;

    public SendChatOutputModel(List<List<String>> chatMembersAddress, int senderUid, int chatUid, String content, String time, int uid)
    {
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.chatMembersAddress = chatMembersAddress;
        this.content = content;
        this.time = time;
        this.uid = uid;

    }

}
