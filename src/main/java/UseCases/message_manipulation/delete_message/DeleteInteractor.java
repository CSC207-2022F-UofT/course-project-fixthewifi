package usecases.message_manipulation.delete_message;

import java.util.List;
import java.util.ArrayList;

public class DeleteInteractor implements DeleteInputBoundary {

    final DeleteOutputBoundary output;
    final DeleteDSGateway dataBase;

    public DeleteInteractor(DeleteDSGateway dataBase, DeleteOutputBoundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

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
