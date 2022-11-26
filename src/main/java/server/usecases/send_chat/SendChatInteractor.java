package server.usecases.send_chat;


import java.util.ArrayList;
import java.util.List;

public class SendChatInteractor implements SendChatInputBoundary
{
    final SendChatDsGateway dataBase;
    final SendChatOutputBoundary output;

    /**
     * Creates a Send Chat usecase object.
     * @param dataBase A database.
     * @param output The output adapter that converts output data to the appropriate form.
     */
    public SendChatInteractor(SendChatDsGateway dataBase, SendChatOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Send chat usecase.
     * @param inputModel A model of the input.
     */
    @Override
    public void SendChat(SendChatInputModel inputModel)
    {
        dataBase.storeChatMsg(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);

        ArrayList<List<String>> chatMembersAddress = dataBase.fetchAllAddressByChatUid(inputModel.chatUid);
        int msgUid = dataBase.generateMsgUid(inputModel.chatUid);
        SendChatOutputModel outputModel = new SendChatOutputModel(chatMembersAddress, msgUid, inputModel.senderUid, inputModel.chatUid, inputModel.content, inputModel.time);

        output.sendChat(outputModel);
    }


}
