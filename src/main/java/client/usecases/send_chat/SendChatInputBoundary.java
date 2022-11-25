package client.usecases.send_chat;

import server.usecases.send_chat.SendChatInputModel;

public interface SendChatInputBoundary
{
    /**
     * Send chat usecase.
     * @param model A model of the input.
     */
    public void SendChat(SendChatInputModel model);
}
