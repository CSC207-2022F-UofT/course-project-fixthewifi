package client.usecases.message;


public interface MessageOutputBoundary
{
    /**
     * Converts the output of the usecase to a String that is to be sent over the internet.
     */
    void sendMsg(int senderUid, int chatUid, String content, String time);
}
