package usecases.send_chat;

public interface SendChatInputBoundary
{
    /**
     * Send chat usecase.
     * @param model A model of the input.
     */
    public void SendChat(SendChatInputModel model);
}
