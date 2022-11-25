package client.usecases.edit_message;

import server.usecases.edit_message.EditOutputModel;

public interface EditOutputBoundary
{
    /**
     * Converts use case output to a String
     * @param edit_model output model of edit message
     */
    void EditMessage(EditOutputModel edit_model);
}
