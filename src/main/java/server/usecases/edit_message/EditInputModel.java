package server.usecases.edit_message;

public class EditInputModel {

    int currentUserUid;
    int senderUid;
    int chatUid;
    String content;
    String time;

    public EditInputModel(int senderUid, int chatUid, String content, String time, int currentUserUid)
    {
        this.senderUid = senderUid;
        this.currentUserUid =currentUserUid;
        this.chatUid = chatUid;
        this.time = time;
        this.content = content;
    }

}
