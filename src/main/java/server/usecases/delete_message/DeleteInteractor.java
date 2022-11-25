package server.usecases.delete_message;

import java.util.ArrayList;
import java.util.List;

public class DeleteInteractor implements DeleteInputBoundary {

    final DeleteOutputBoundary output;
    final DeleteDSGateway dataBase;

    /**
     * Creates Delete Message use case object
     * @param dataBase database of the messages
     * @param output output adapter that converts the output data to the appropriate format
     */
    public DeleteInteractor(DeleteDSGateway dataBase, DeleteOutputBoundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Use case of Delete Message
     * @param inputModel input model
     */
    @Override
    public void deleteMessage(DeleteInputModel inputModel) {

        if (inputModel.senderUid == inputModel.currentUserUid){
            dataBase.deleteMessage(inputModel.chatUid);
            ArrayList<List<String>> chatMemberAddress = dataBase.fetchMembersAddress(inputModel.chatUid);
            DeleteOutputModel outputModel = new DeleteOutputModel(chatMemberAddress, inputModel.senderUid, inputModel.chatUid, inputModel.content, inputModel.time);

            output.DeleteMessage(outputModel);
        }


    }
}
