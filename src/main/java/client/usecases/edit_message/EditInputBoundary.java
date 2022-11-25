package client.usecases.edit_message;

import server.usecases.edit_message.EditInputModel;

public interface EditInputBoundary {
    /**
     * Use case of Edit Message
     * @param edit_model input model of edit message
     */
    void editMessage(EditInputModel edit_model);

}
