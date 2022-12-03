package server.usecases.send_message;

public interface SendMsgInputBoundary
{
    /**
     * Send chat usecase.
     * @param model A model of the input.
     */
    public void SendChat(SendMsgInputModel model);
}
