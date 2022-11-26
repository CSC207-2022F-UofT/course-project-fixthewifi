package client.usecases.message;

public interface MessageInputBoundary
{
    /**
     * Send chat usecase.
     */
    void sendMsg(String content, int chatUid);
    void receiveMsg(int msgUid, int senderUid, int chatUid, String content, String time);
}
