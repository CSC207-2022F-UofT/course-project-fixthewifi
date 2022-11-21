package usecases.message_manipulation.edit_message;

public interface EditInputBoundary {
    /**
     * Use case of Edit Message
     * @param edit_model input model of edit message
     */
    void editMessage(EditInputModel edit_model);

}
