package server.usecases.edit_message;

public interface EditOutputBoundary
{
    /**
     * Converts use case output to a String
     */
    void EditMessage(int chatUid, int msgUid, String newContent, String address, int port);
}
