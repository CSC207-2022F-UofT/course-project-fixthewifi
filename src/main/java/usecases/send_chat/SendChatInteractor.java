package usecases.send_chat;

import entities.*;

import java.util.ArrayList;
import java.util.List;

public class SendChatInteractor implements SendChatInputBoundary
{
    final SendChatDsGateway dataBase;
    final SendChatOutputBoundary output;

    public SendChatInteractor(SendChatDsGateway dataBase, SendChatOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void SendChat(SendChatInputModel inputModel)
    {
        dataBase.storeChat(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);

        ArrayList<List<String>> chatMembersAddress = dataBase.fetchAllAddressByChatUid(inputModel.chatUid);
        SendChatOutputModel outputModel = new SendChatOutputModel(chatMembersAddress, inputModel.senderUid, inputModel.content, inputModel.time);

        output.SendChat(outputModel);
    }


}
