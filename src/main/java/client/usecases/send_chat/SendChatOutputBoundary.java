package client.usecases.send_chat;

import server.usecases.send_chat.SendChatOutputModel;

public interface SendChatOutputBoundary
{
    /**
     * Converts the output of the usecase to a String that is to be sent over the internet.
     * @param model A model of the output.
     */
    void sendChat(SendChatOutputModel model);
}
