package server.usecases.delete_message;

import java.util.ArrayList;
import java.util.List;
public interface DeleteDSGateway {
    /**
     *
     * @param msgUid Uid of the message
     */
    void deleteMsg(int msgUid);

    /**
     *
     * @param msgUid Uid of the message
     * @return returns the information that output model needs.
     */
    DeleteOutputModel fetchMsgInfo(int msgUid);

    /**
     * Returns the port number and ip address of all users in the chat as a list of tuples of length of 2
     * @param chatUid uid of the message
     * @return A list of tuple of the port number and ip address of all users in the chat
     */
    ArrayList<List<String>> fetchMembersAddress(int chatUid);

    }

