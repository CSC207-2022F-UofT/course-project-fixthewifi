package server.usecases.send_message;


import java.util.ArrayList;
import java.util.List;

public class SendMsgInteractor implements SendMsgInputBoundary
{
    final sendMsgDsGateway dataBase;
    final SendMsgOutputBoundary output;

    /**
     * Creates a Send Chat usecase object.
     * @param dataBase A database.
     * @param output The output adapter that converts output data to the appropriate form.
     */
    public SendMsgInteractor(sendMsgDsGateway dataBase, SendMsgOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Send chat usecase.
     * @param inputModel A model of the input.
     */
    @Override
    public void SendChat(SendMsgInputModel inputModel)
    {
        dataBase.storeChatMsg(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);

        ArrayList<List<String>> chatMembersAddress = dataBase.fetchAllAddressByChatUid(inputModel.chatUid);
        int msgUid = dataBase.generateMsgUid(inputModel.chatUid);
        SendMsgOutputModel outputModel = new SendMsgOutputModel(chatMembersAddress, msgUid, inputModel.senderUid, inputModel.chatUid, inputModel.content, inputModel.time);

        output.sendChat(outputModel);
    }


}
