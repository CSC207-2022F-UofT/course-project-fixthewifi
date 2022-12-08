package server.interface_adapters.edit_delete_msg;

import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.edit_message.EditOutputBoundary;
import server.usecases.edit_message.EditOutputModel;

import java.util.List;

public class EditMessageOutputAdapter implements EditOutputBoundary {
    private final IfComManager comManager;
    public EditMessageOutputAdapter(IfComManager comManager){
        this.comManager = comManager;
    }
    @Override
    public void EditMessage(int chatUid, int msgUid, String newContent, String address, int port) {

        char separator = 30;
        String msgContent = Constants.EDIT_MSG + "#" + String.join(String.valueOf(separator), String.valueOf(chatUid), String.valueOf(msgUid),
                newContent);
        comManager.send(address, port, msgContent);
    }
}
