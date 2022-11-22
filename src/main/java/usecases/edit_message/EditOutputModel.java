package usecases.edit_message;

import java.util.List;

public class EditOutputModel {

    public List<List<String>> membersAddress;
    public int senderUid;
    public int chatUid;
    public String edited_content;
    public String time;

    public EditOutputModel(List<List<String>> membersAddress, int senderUid, int chatUid, String edited_content, String time){

        this.membersAddress = membersAddress;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.edited_content = edited_content;
        this.time = time;
    }

}
