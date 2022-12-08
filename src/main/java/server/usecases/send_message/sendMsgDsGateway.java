package server.usecases.send_message;

import java.util.ArrayList;
import java.util.List;

public interface sendMsgDsGateway
{
    /**
     * Stores a chat message in the database.
     * @param chatUid The uid of the chat.
     * @param senderUid The uid of the sender.
     * @param content The content of the chat.
     * @param time The time at which the chat is sent.
     */
    void storeChatMsg(int chatUid, int senderUid, String content, String time);

    /**
     * Returns the port number and ip address all users in a chat as a list of tuples of length 2.
     * @param chatUid The uid of the chat.
     * @return A list of tuple of the port number and ip address of all users in the chat.
     */
    ArrayList<List<String>> fetchAllAddressByChatUid(int chatUid);

    int generateMsgUid(int chatUid);
}
