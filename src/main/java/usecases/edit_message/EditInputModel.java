package usecases.edit_message;

public class EditInputModel {

    int msgUid;
    int currentUserUid;
    int senderUid;
    int chatUid;
    String edited_content;


    public EditInputModel(int msgUid, int senderUid, int chatUid, String edited_content, int currentUserUid)
    {
        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.currentUserUid =currentUserUid;
        this.chatUid = chatUid;
        this.edited_content = edited_content;
    }

}
