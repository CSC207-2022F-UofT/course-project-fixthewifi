package client.usecases.edit_message;

import server.usecases.edit_message.*;
import server.usecases.edit_message.EditDSGateway;
import server.usecases.edit_message.EditInputModel;

import java.util.ArrayList;
import java.util.List;

public class EditInteractor implements EditInputBoundary {

    final EditOutputBoundary output;
    final server.usecases.edit_message.EditDSGateway dataBase;

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
     * @param inputModel input model of edit message
     */
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
