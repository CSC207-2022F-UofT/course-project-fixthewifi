package usecases.message_manipulation.delete_message;


public class DeleteInputModel
{
    int currentUserUid;
    int senderUid;
    int chatUid;
    String content;
    String time;

    public DeleteInputModel(int senderUid, int chatUid, String content, String time, int currentUserUid)
    {
        this.senderUid = senderUid;
        this.currentUserUid = currentUserUid;
        this.chatUid = chatUid;
        this.time = time;
        this.content = content;
    }

}
