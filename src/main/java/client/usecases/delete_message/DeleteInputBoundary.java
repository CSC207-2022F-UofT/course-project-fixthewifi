package client.usecases.delete_message;

import server.usecases.delete_message.DeleteInputModel;

public interface DeleteInputBoundary {
    /**
     * Use case of Delete Message
     * @param delete_model input model of delete message
     */
    void deleteMessage(DeleteInputModel delete_model);


}
