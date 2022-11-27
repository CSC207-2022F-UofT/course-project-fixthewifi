package usecases.delete_message;


public class DeleteInputModel
{
    int msgUid;
    int currentUserUid;
    int senderUid;
    int chatUid;


    public DeleteInputModel(int msgUid, int senderUid, int currentUserUid, int chatUid)
    {
        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.currentUserUid = currentUserUid;
        this.chatUid = chatUid;


    }

}
