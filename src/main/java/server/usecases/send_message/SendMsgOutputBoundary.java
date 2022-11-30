package server.usecases.send_message;

public interface SendMsgOutputBoundary
{
    /**
     * Converts the output of the usecase to a String that is to be sent over the internet.
     * @param model A model of the output.
     */
    void sendChat(SendMsgOutputModel model);
}
