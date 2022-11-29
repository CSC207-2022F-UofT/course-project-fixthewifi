package usecases.edit_message;

import java.util.ArrayList;
import java.util.List;

public interface EditDSGateway {
    /**
     *
     * @param msgUid Uid of the message
     */
    void editMsg(int msgUid);

    EditOutputModel fetchMsgInfo(int msgUid);

    /**
     * Returns the port number and ip address of all uses in the chat
     * @param chatUid uid of the message
     * @return A list of tuple of the port number and ip address of all users in the chat
     */
    ArrayList<List<String>> fetchMembersAddress(int chatUid);
}
