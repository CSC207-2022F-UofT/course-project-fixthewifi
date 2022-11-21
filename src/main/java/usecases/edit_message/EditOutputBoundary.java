package usecases.edit_message;

public interface EditOutputBoundary
{
    /**
     * Converts use case output to a String
     * @param edit_model output model of edit message
     */
    void EditMessage(EditOutputModel edit_model);
}
