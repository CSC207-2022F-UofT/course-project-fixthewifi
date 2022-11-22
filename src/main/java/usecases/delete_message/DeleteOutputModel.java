package usecases.delete_message;

import java.util.List;

public class DeleteOutputModel
{
    public List<List<String>> membersAddress;
    public int senderUid;
    public int chatUid;
    public String time;


    public DeleteOutputModel(List<List<String>> membersAddress, int senderUid, int chatUid, String time){

        this.membersAddress = membersAddress;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.time = time;
    }

}
