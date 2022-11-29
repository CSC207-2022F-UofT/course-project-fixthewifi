package usecases.delete_message;

import java.util.List;

public class DeleteOutputModel
{
    public List<List<String>> membersAddress;
    public int msgUid;
    public int senderUid;
    public int chatUid;
    public String content;
    public String time;


    public DeleteOutputModel(List<List<String>> membersAddress, int msgUid, int senderUid, int chatUid, String content, String time){

        this.membersAddress = membersAddress;
        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.content = content;
        this.time = time;
    }

}
