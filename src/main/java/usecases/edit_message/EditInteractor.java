package usecases.edit_message;

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
     * @param inputModel input model of edit message
     */
    @Override
    public void editMessage(EditInputModel inputModel) {
        if(inputModel.senderUid == inputModel.currentUserUid){
            dataBase.editMsg(inputModel.msgUid);
            EditOutputModel msgInfo = dataBase.fetchMsgInfo(inputModel.msgUid);
            ArrayList<List<String>> chatMemberAddress = dataBase.fetchMembersAddress(inputModel.chatUid);
            EditOutputModel outputModel = new EditOutputModel(chatMemberAddress, msgInfo.msgUid, msgInfo.senderUid, msgInfo.chatUid, msgInfo.edited_content, msgInfo.time);

            output.EditMessage(outputModel);;
        }

    }
}
