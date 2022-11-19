package usecases.message_manipulation.edit_message;

import usecases.message_manipulation.delete_message.DeleteDSGateway;
import usecases.message_manipulation.delete_message.DeleteOutputModel;

import java.util.ArrayList;
import java.util.List;

public class EditInteractor implements EditInputBoundary{

    final EditOutputBoundary output;
    final EditDSGateway dataBase;

    public EditInteractor(EditDSGateway dataBase, EditOutputBoundary output){
        this.dataBase = dataBase;
        this.output = output;
    }


    @Override
    public void editMessage(EditInputModel inputModel) {

        if(inputModel.senderUid == inputModel.currentUserUid){
            dataBase.editMessage(inputModel.chatUid);
            ArrayList<List<String>> chatMemberAddress = dataBase.fetchMembersAddress(inputModel.chatUid);
            EditOutputModel outputModel = new EditOutputModel(chatMemberAddress, inputModel.senderUid, inputModel.chatUid, inputModel.content, inputModel.time);

            output.EditMessage(outputModel);;
        }

    }
}
