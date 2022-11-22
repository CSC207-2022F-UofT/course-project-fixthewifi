package usecases.delete_message;


public class DeleteInputModel
{

    int currentUserUid;
    int senderUid;
    int chatUid;
    String time;

    public DeleteInputModel(int senderUid, int chatUid, String deleted_content, String time, int currentUserUid)
    {
        this.senderUid = senderUid;
        this.currentUserUid = currentUserUid;
        this.chatUid = chatUid;
        this.time = time;

    }

}
