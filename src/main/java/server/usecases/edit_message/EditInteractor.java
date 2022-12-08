package server.usecases.edit_message;

import java.util.ArrayList;
import java.util.List;

public class EditInteractor implements EditInputBoundary {

    final EditOutputBoundary output;
    final EditDSGateway dataBase;

    /**
     * Creates Edit Message use case object
     * @param dataBase database of the messages
     * @param output output adapter that converts the output data to the appropriate format
     */
    public EditInteractor(EditDSGateway dataBase, EditOutputBoundary output){
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Use case of Edit Message
     */
    @Override
    public void editMessage(int chatUid, int msgUid, int senderUid, int userUid, String newContent) {
        if(senderUid == userUid){
            dataBase.editMessage(chatUid, msgUid, newContent);
            List<Integer> membersUid = dataBase.getAllMemberUid(chatUid);
            for (int memberUid : membersUid)
            {
                String address = dataBase.getAddress(memberUid);
                int port = dataBase.getPort(memberUid);
                output.EditMessage(chatUid, msgUid, newContent, address, port);
            }
        }

    }
}
