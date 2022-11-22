package interface_adapters.delete_message;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.delete_message.DeleteOutputBoundary;
import usecases.delete_message.DeleteOutputModel;
import java.util.List;

public class DeleteMessageOutputAdapter implements DeleteOutputBoundary{
    private final IfComManager comManager;
    public DeleteMessageOutputAdapter(IfComManager comManager){
        this.comManager = comManager;
    }

    @Override
    public void DeleteMessage(DeleteOutputModel delete_model) {

        char separator = 30;

        String msgContent = String.join(String.valueOf(separator), String.valueOf(delete_model.senderUid),
                String.valueOf(delete_model.chatUid), delete_model.time);

        for (List<String> addressPair : delete_model.membersAddress){
            comManager.send(addressPair.get(0), Integer.parseInt(addressPair.get(1)), msgContent);
        }


    }
}
