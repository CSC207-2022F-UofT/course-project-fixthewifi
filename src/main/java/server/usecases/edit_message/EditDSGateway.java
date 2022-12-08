package server.usecases.edit_message;

import java.util.ArrayList;
import java.util.List;

public interface EditDSGateway {
    /**
     *
     * @param msgUid Uid of the message
     */
    void editMessage(int chatUid, int msgUid, String newContent);

    List<Integer> getAllMemberUid(int chatUid);

    String getAddress(Integer memberUid);

    int getPort(Integer memberUid);
}
