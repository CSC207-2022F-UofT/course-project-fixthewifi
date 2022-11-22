package interface_adapters.edit_message;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.edit_message.EditOutputBoundary;
import usecases.edit_message.EditOutputModel;

import java.util.List;

public class EditMessageOutputAdapter implements EditOutputBoundary {
    private final IfComManager comManager;
    public EditMessageOutputAdapter(IfComManager comManager, IfComManager comManager1){
        this.comManager = comManager;
    }
    @Override
    public void EditMessage(EditOutputModel edit_model) {

        char separator = 30;
        String msgContent = String.join(String.valueOf(separator), String.valueOf(edit_model.senderUid),
                String.valueOf(edit_model.chatUid), edit_model.edited_content, edit_model.time);

        for (List<String> addressPair : edit_model.membersAddress){
            comManager.send(addressPair.get(0), Integer.parseInt(addressPair.get(1)), msgContent);
        }

    }
}
