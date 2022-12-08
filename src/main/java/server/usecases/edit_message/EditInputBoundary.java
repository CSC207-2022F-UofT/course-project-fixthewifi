package server.usecases.edit_message;

public interface EditInputBoundary {
    /**
     * Use case of Edit Message
     * @param edit_model input model of edit message
     */
    void editMessage(int chatUid, int msgUid, int senderUid, int userUid, String newContent);

}
