package usecases.message_manipulation.delete_message;

public interface DeleteInputBoundary {
    /**
     * Use case of Delete Message
     * @param delete_model input model of delete message
     */
    void deleteMessage(DeleteInputModel delete_model);


}
