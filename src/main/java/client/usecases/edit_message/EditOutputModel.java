package client.usecases.edit_message;

import java.util.List;

public class EditOutputModel {

    public List<List<String>> membersAddress;
    public int senderUid;
    public int chatUid;
    public String content;
    public String time;

    public EditOutputModel(List<List<String>> membersAddress, int senderUid, int chatUid, String content, String time){

        this.membersAddress = membersAddress;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.content = content;
        this.time = time;
    }

}
